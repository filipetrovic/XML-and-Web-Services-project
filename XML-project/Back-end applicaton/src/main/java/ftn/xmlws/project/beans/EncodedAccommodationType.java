package ftn.xmlws.project.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// Sifarnik za tipove smestaja
@Entity
@Table(name="encoded_accomodation_types")
public class EncodedAccommodationType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique=true)
	private String name;
	
	public EncodedAccommodationType() {}

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
