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
	private String iedIp;
	
	@Column(name="stationid")
	private Long stationId;
	
	@OneToMany(mappedBy="ied", cascade=CascadeType.ALL)
	private List<IEDSignal> iedSignals;
	
	public Long getIedId() {return iedId;}
	public void setIedId(Long id) {this.iedId = id;}
	
	public String getIedName() {return name;}
	public void setIedName(String name) {this.name = name;}
	
	public String getIedIp() {return iedIp;}
	public void setIedIp(String iedIp) {this.iedIp = iedIp;}
	
	public Long getStationId() {return stationId;}
	public void setStationId(Long stationId) {this.stationId = stationId;}
}