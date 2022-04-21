package com.stedin.HighVoltage.model;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.stedin.HighVoltage.repositories.IEDRepository;
import com.stedin.HighVoltage.repositories.StationRepository;
import com.stedin.HighVoltage.services.IEDService;
import com.stedin.HighVoltage.services.StationService;

@Component
public class FileManager {

	@Autowired
	public StationService stationService;

	@Autowired
	public StationRepository stationRepository;

	@Autowired
	public IEDService iedService;

	@Autowired
	public IEDRepository iedRepository;

	public static void importIO() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int returnValue = fc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = new File(fc.getSelectedFile().getAbsolutePath());
			System.out.println(file.getName());
		}
	}

	public Document readAndNormalizeSCD(String path)  {
		
		Document document = null;

		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		// optional but recommended, process xml securly, avoid attacks like XML
		// External Entities(XXE)
		dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		document = db.parse(new File(path));
		} catch (IOException | ParserConfigurationException | SAXException e){
			e.printStackTrace();
		}
		// optional but recommended, removes whitespaces etc.
		document.getDocumentElement().normalize();

		return document;
	}

	// import .scd to construct the basic station lay-out
	public void importSCD(String path) {

		// read, normalize and return xml document
		Document scd = readAndNormalizeSCD(path);
		
		System.out.println("Root Element: " + scd.getDocumentElement().getNodeName());
		System.out.println("XML Namespace: " + scd.getDocumentElement().getAttribute("xmlns"));
		System.out.println("-----------------------------------");
		
		//Retrieve stationName from .scd and create a new station if it not excists
		Station substation = stationService.addStation(scd.getElementsByTagName("Substation").item(0).getAttributes().getNamedItem("name").getNodeValue());
		
		//Get the ConnectAP's from the .scd
		NodeList list = scd.getElementsByTagName("ConnectedAP");


		
		// Iterate over list to find the ELEMENT_NODE's and work with them
		for (int i = 0; i < list.getLength(); i++) {
			
			String ip = "";
			String subnet = "";
			String gateway = "";
			String iedName = "";
			String apName = "";

			// Get single Node (Element=ConnectAP) from the list and cast it to Object Element.
			// This is possible because Element implements Node
			Element connectAP = (Element) list.item(i);

			// get the attributes of the ConnectedAP element
			iedName = connectAP.getAttribute("iedName");
			apName = connectAP.getAttribute("apName");

			// get the Address Elements from the ConnectAP Element
			NodeList address = connectAP.getElementsByTagName("Address");

			// Get Address information from the Address Element
			

			for (int j = 0; j < address.getLength(); j++) {
				Element a = (Element) address.item(j);
				NodeList pList = a.getElementsByTagName("P");

				// read the list of Elements P
				for (int k = 0; k < pList.getLength(); k++) {
					// System.out.println(pList.item(k).getNodeName() + " " +
					// pList.item(k).getAttributes().getNamedItem("type").getNodeValue());

					switch (pList.item(k).getAttributes().getNamedItem("type").getNodeValue()) {
					case "IP":
						ip = pList.item(k).getTextContent();
					case "IP-SUBNET":
						subnet = pList.item(k).getTextContent();
					case "IP-GATEWAY":
						gateway = pList.item(k).getTextContent();
					}
				}
			}
			
			iedService.addIED(apName, gateway, ip, iedName, substation.getStationID(), subnet, path);

			System.out.println("name: " + iedName + "  apName: " + apName + "  ip: " + ip + "  subnet: " + subnet
					+ "  gateway: " + gateway + "\n");

			// see if IED already exists in DB
			/*
			 * IED ied = iedRepository.findByName(name); if (ied != null) {
			 * System.out.println("IED already exists"); } else {
			 * iedService.addIED(communication, ip, name, station.getStationID(), voltage);
			 * }
			 */
		}

	}
}
