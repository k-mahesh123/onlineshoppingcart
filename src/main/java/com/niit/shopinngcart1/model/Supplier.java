package com.niit.shopinngcart1.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Table
@Entity
@Component
@Proxy(lazy=false)
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int supid;
	@Column
	@NotNull
	@Size(min=2,max=10)
	private String supname;
	@NotNull
	@Size(min=2,max=10)
	private String supaddress;
	@NotNull

	private String supemail;
	@NotNull
	@Size(min=10,max=12)
	private String supcontact;

	
	

	public String getSupemail() {
		return supemail;
	}

	public void setSupemail(String supemail) {
		this.supemail = supemail;
	}

	public int getSupid() {
		return supid;
	}
	
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getSupaddress() {
		return supaddress;
	}
	public void setSupaddress(String supaddress) {
		this.supaddress = supaddress;
	}
	
	public String getSupcontact() {
		return supcontact;
	}
	public void setSupcontact(String supcontact) {
		this.supcontact = supcontact;
	}
	
	

}
