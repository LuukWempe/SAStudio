package com.stedin.HighVoltage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stations")
public class Station{
	
	@Id
	@GeneratedValue
	private long stationID;

	@Column(name="stationName")
	private String stationName;
	
	@Column(name="stationStatus")
	private Boolean stationStatus;
	
	@Column(name="stationAddress")
	private String stationAddress;


	//Constructor
	public Station() {
		
	}
	
	public Station(String stationName, Boolean stationStatus, String stationAddress) {
		this.stationName = stationName;
		this.stationStatus = stationStatus;
		this.stationAddress = stationAddress;
		
	}
	
	//Getters and Setters
	public long getStationID() {return stationID;}
	public void setStationID(long stationID) {this.stationID = stationID;}

	public String getStationName() {return stationName;}
	public void setStationName(String stationName) {this.stationName = stationName;}
	
	public Boolean getStationStatus() {return stationStatus;}
	public void setStationStatus(Boolean stationStatus) {this.stationStatus = stationStatus;}
	
	public String getStationAddress() {return stationAddress;}
	public void setStationAddress(String stationAddress) {this.stationAddress = stationAddress;}
		
}
