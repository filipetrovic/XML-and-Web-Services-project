package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;

public class AccommodationType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	public AccommodationType() {}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String typeName) {
		this.name = typeName;
	}
	
	
	
}
