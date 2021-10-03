package com.stedin.HighVoltage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iedsignals")
public class IEDSignal{
	
	@Id
	@GeneratedValue
	private long signalID;
	
	@Column(name="signalname")
	private String signalName;
	
	@Column(name="iedid")
	private Long iedID;
	
	@Column(name="asdu")
	private int asdu;
	
	public IEDSignal() {}
	
	public IEDSignal(String signalName, Long iedID, int asdu) {
		this.signalName = signalName;
		this.iedID = iedID;
		this.asdu = asdu;
	}
	
	
	public Long getSignalID() {return signalID;}
	public void setSignalID(Long signalID) {this.signalID = signalID;}
	
	public String getSignalName() {return signalName;}
	public void setSignalName(String signalName) {this.signalName = signalName;}
	
	public Long getIEDID() {return iedID;}
	public void setIEDID(Long iedID) {this.iedID = iedID;}
	
	public int getASDU() {return asdu;}
	public void setASDU(int asdu) {this.asdu = asdu;}
	
}