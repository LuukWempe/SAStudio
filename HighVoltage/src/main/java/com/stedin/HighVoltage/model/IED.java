package com.stedin.HighVoltage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IEDs")
public class IED {
	
	@Id
	@GeneratedValue
	private Long iedID;
	
	@Column(name="IEDName")
	private String iedName;
	
	@Column(name="IEDIP")
	private String iedIP;
	
	@Column(name="StationID")
	private Long stationID;
	
	public Long getIEDID() {return iedID;}
	public void setIEDID(Long iedID) {this.iedID = iedID;}
	
	public String getIEDName() {return iedName;}
	public void setIEDName(String iedName) {this.iedName = iedName;}
	
	public String getIEDIP() {return iedIP;}
	public void setIEDIP(String iedIP) {this.iedIP = iedIP;}
	
	public Long getStationID() {return stationID;}
	public void setStationID(Long stationID) {this.stationID = stationID;}
}