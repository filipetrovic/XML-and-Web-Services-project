package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;

public class Facility implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private int version;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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
