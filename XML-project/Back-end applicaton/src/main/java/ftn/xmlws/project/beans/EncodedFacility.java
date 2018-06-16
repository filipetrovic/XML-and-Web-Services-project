package ftn.xmlws.project.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.BatchSize;

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
