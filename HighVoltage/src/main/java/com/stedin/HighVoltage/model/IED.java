package com.stedin.HighVoltage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ied")
public class IED {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iedId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="voltage")
	private String voltage;
	
	@Column(name="communication")
	private String communication;
	
	@Column(name="iedip")
	private String iedIp;
	
	@Column(name="stationid")
	private Long stationId;
	
	@OneToMany(mappedBy="ied", cascade=CascadeType.ALL)
	private List<IEDSignal> iedSignals;
	
	//Constructor from FileManager.readSCD()
	public IED(String communication,String ip, String name, Long stationId, String voltage) {
		this.name = name;
		this.voltage = voltage;
		this.iedIp = ip;
		this.communication = communication;
		this.stationId = stationId;
	}
	
	public IED(){}
	
	
	//Getters and Setters
	public Long getIedId() {return iedId;}
	public void setIedId(Long id) {this.iedId = id;}
	
	public String getIedName() {return name;}
	public void setIedName(String name) {this.name = name;}
	
	public String getIedVoltage() {return voltage;}
	public void setIedVoltage(String voltage) {this.voltage = voltage;}
	
	public String getIedcommunication() {return communication;}
	public void setIedcommunication(String communication) {this.communication = communication;}
	
	public String getIedIp() {return iedIp;}
	public void setIedIp(String iedIp) {this.iedIp = iedIp;}
	
	public Long getStationId() {return stationId;}
	public void setStationId(Long stationId) {this.stationId = stationId;}
}