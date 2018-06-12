package ftn.xmlws.adminmodule.beans;

import java.io.Serializable;

public class EncodedFacility implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long facilityId;
	private String facilityName;
	
	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public EncodedFacility() {}
	
	
}
