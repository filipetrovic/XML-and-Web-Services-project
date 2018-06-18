package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;

public class AccommodationType implements Serializable {
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

	public void setId(Long id) {
		this.id = id;
	}

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
