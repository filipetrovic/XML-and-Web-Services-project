package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;


public class Agent implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	
	private String name;
	
	
	private String surname;
	
	
	private String address;
	
	
	private String bussinessNumber;
	
	public Agent () {}
	
	public Agent(String name, String surname, String address, String bussinessNumber ) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.bussinessNumber = bussinessNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBussinessNumber() {
		return bussinessNumber;
	}

	public void setBussinessNumber(String bussinessNumber) {
		this.bussinessNumber = bussinessNumber;
	}

}
