package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;

public class AccommodationType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long typeId;
	private String typeName;
	
	public AccommodationType() {}

	public Long getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
}
