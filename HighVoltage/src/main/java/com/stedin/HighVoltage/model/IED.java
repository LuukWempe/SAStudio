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
	
	@Column(name="gateway")
	private String gateway;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="subnet")
	private String subnet;

	@Column(name="stationid")
	private Long stationId;
	
	@OneToMany(mappedBy="ied", cascade=CascadeType.ALL)
	private List<IEDSignal> iedSignals;
	
	//Constructor from FileManager.readSCD()
	public IED(String communication,String gateway, String ip, String name, Long stationId, String subnet, String voltage) {
		this.name = name;
		this.voltage = voltage;
		this.gateway = gateway;
		this.ip = ip;
		this.subnet = subnet; 
		this.stationId = stationId;
	}
	
	public IED(){}
	
	
	//Getters and Setters
	public Long getIedId() {return iedId;}
	public void setIedId(Long id) {this.iedId = id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getVoltage() {return voltage;}
	public void setVoltage(String voltage) {this.voltage = voltage;}
	
	public String getCommunication() {return communication;}
	public void setCommunication(String communication) {this.communication = communication;}
	
	public String getGateway() {return gateway;}
	public void setGateway(String gateway) {this.gateway = gateway;}
	
	public String getIp() {return ip;}
	public void setIp(String ip) {this.ip = ip;}
	
	public String getSubnet() {return subnet;}
	public void setSubnet(String subnet) {this.subnet = subnet;}
	
	public Long getStationId() {return stationId;}
	public void setStationId(Long stationId) {this.stationId = stationId;}
}