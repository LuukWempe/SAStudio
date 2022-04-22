package com.stedin.HighVoltage.model.ied;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="configuration")
public class Configuration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ied_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ied_id")
	private IED ied;
	
	@Column(name="gateway")
	private String gateway;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="subnet")
	private String subnet;
	
	//Constructor
	public Configuration(){}
	
	public Configuration(IED ied, String gateway, String ip, String subnet){
		this.ied = ied;
		this.gateway = gateway;
		this.ip = ip;
		this.subnet = subnet; 
	}
	
	public Configuration(String gateway, String ip, String subnet){
		this.gateway = gateway;
		this.ip = ip;
		this.subnet = subnet; 
	}
	
	public Configuration(Long iedId) {
		this.id = iedId;
		// TODO Auto-generated constructor stub
	}

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public IED getIED() {return ied;}
	public void setIED(IED ied) {this.ied = ied;}
	
	public String getGateway() {return gateway;}
	public void setGateway(String gateway) {this.gateway = gateway;}
	
	public String getIp() {return ip;}
	public void setIp(String ip) {this.ip = ip;}
	
	public String getSubnet() {return subnet;}
	public void setSubnet(String subnet) {this.subnet = subnet;}

	public String toString() {
		String s = "ip: " + this.ip + " gateway: " + this.gateway + " subnet: " + this.subnet;
		return s;
	}
}
