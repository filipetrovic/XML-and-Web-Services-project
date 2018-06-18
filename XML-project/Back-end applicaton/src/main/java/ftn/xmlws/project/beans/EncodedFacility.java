package ftn.xmlws.project.beans;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

// Sifarnik za dodatne usluge

@Entity
@Table(name = "encoded_facilities")
public class EncodedFacility implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@NotNull
	@Column
	private String name;
	
	@Version
	private int version;
	
	public EncodedFacility() {}
	
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

	
}
