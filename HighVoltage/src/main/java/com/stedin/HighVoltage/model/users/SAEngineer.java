package com.stedin.HighVoltage.model.users;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class SAEngineer extends AppUser{



	@Id
	@GeneratedValue
	private Long id;

	//@ManyToOne
	//@JoinColumn(name = "BOOTCAMP_ID")
	//private Bootcamp bootcamp;

	@OneToOne
	@JoinColumn(name ="userId", insertable = false, updatable = false)
	private AppUser user;


	public SAEngineer(){}

	public SAEngineer(String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated, Date dateofbirth, String zipcode, String street, String streetNr, String city, String country, String telephonenumber) {
		super(username, firstName, lastName, email, password, role, enabled, activated, dateofbirth, zipcode, street, streetNr, city, country, telephonenumber);
	}
	
	public SAEngineer (String username, String firstName, String lastName, String email, String password, String role, boolean enabled, boolean activated) {
		super (username, firstName, lastName, email, password, role, enabled, activated);
	}
	
	//public void setBootcamp(Bootcamp bootcamp) {
	//	this.bootcamp = bootcamp;
	//}
	
	//public Bootcamp getBootcamp () {
	//	return bootcamp;
	//}


}