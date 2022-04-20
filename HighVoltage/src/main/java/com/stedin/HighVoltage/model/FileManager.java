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
public class FileManager{

	
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
	
	//import .scd to construct the basic station lay-out
	public void readSCD(String filePath) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			//optional but recommended, process xml securly, avoid attacks like XML External Entities(XXE)
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(new File(filePath));
			
			//optional but recommended
			doc.getDocumentElement().normalize();
			
			
			//retrieve stationID or create new station
			String stationName = doc.getDocumentElement().getAttribute("name");
			Station station = stationRepository.findByStationName(stationName);
			if (station != null) {
				System.out.println("Station already exists");
			} else {
				stationService.addStation(stationName);
				station = stationRepository.findByStationName(stationName);
			}

			
			System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
			System.out.println("Station name: " + doc.getDocumentElement().getAttribute("name"));
			System.out.println("-----------------------------------");
			
			//get list of IED's in station
			NodeList list = doc.getElementsByTagName("ied");
			
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					
					// get the first IED
					Element element = (Element) node;
					
					// get ied id
					String name = element.getAttribute("name");
					
					// get IED parameters
					String voltage = element.getElementsByTagName("voltage").item(0).getTextContent();
					String communication = element.getElementsByTagName("communication").item(0).getTextContent();
					String ip = element.getElementsByTagName("ip").item(0).getTextContent();
					
					//see if IED already exists in DB
					IED ied = iedRepository.findByName(name);
					if (ied != null) {
						System.out.println("IED already exists");
					} else {
						iedService.addIED(communication, ip, name, station.getStationID(), voltage);
					}
					
					System.out.println("Current Element: " + node.getNodeName());
					System.out.println("	IED name: " + name);
					System.out.println("	IED Voltage: " + voltage);
					System.out.println("	IED Communication: " + communication + "\n");
				}
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}
		
	}
}

