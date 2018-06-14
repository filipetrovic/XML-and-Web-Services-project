package ftn.xmlws.project.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// Sifarnik za dodatne usluge

@Entity
@Table(name = "encoded_facilities")
public class EncodedFacility implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private String name;
	
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
