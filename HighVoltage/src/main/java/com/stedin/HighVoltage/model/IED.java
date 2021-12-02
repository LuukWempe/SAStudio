package com.stedin.HighVoltage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ied")
public class IED {
	
	@Id
	@GeneratedValue
	private Long iedId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="iedip")
	private String iedIP;
	
	@Column(name="StationID")
	private Long stationID;
	
	@OneToMany(mappedBy="ied", cascade=CascadeType.ALL)
	private List<IEDSignal> iedSignals;
	
	public Long getIEDID() {return iedId;}
	public void setIEDID(Long id) {this.iedId = id;}
	
	public String getIEDName() {return name;}
	public void setIEDName(String name) {this.name = name;}
	
	public String getIEDIP() {return iedIP;}
	public void setIEDIP(String iedIP) {this.iedIP = iedIP;}
	
	public Long getStationID() {return stationID;}
	public void setStationID(Long stationID) {this.stationID = stationID;}
}