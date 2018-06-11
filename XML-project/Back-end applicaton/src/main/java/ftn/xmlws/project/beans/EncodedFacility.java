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
	private Long facilityID;
	
	@NotNull
	@Column
	private String facilityName;
	
	public EncodedFacility() {}
}
