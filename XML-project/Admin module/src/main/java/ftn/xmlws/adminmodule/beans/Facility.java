package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;

public class Facility implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long facilityId) {
		this.id = facilityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String facilityName) {
		this.name = facilityName;
	}

	public Facility() {}
	
	
}
