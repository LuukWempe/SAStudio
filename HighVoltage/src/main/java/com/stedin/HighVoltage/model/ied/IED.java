package com.stedin.HighVoltage.model.ied;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ied")
public class IED {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long iedId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="voltage")
	private String voltage;
	
	@OneToOne(mappedBy="ied", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Configuration configuration;

	@Column(name="stationid")
	private Long stationId;
	
	@OneToMany(mappedBy="ied", cascade=CascadeType.ALL)
	private List<IEDSignal> iedSignals;
	
	
	
	
	//Constructor from FileManager.readSCD()
	public IED(Configuration configuration, String name, Long stationId, String voltage) {
		this.configuration = configuration;
		this.name = name;
		this.voltage = voltage;
		this.stationId = stationId;
	}
	
	public IED(String name, Long stationId, String voltage) {
		this.configuration = new Configuration(this.getIedId());
		this.name = name;
		this.voltage = voltage;
		this.stationId = stationId;
	}
	
	public IED(){}
	
	
	//Getters and Setters
	public Long getIedId() {return iedId;}
	public void setIedId(Long iedId) {this.iedId = iedId;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getVoltage() {return voltage;}
	public void setVoltage(String voltage) {this.voltage = voltage;}
	
	public Configuration getConfiguration() {return configuration;}
	public void setConfiguration(Configuration configuration) {this.configuration = configuration;}
	
	public Long getStationId() {return stationId;}
	public void setStationId(Long stationId) {this.stationId = stationId;}
}