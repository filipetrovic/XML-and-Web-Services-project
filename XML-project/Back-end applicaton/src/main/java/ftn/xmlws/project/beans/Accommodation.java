package ftn.xmlws.project.beans;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "accommodation")
public class Accommodation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Date startDateAvailable;
	
	@Column
	private Date endDateAvailable;
	
	@Column
	private String name;
	
	@Column String pictures;
	
	@Column
	private String description;
	
	@Column
	private float pricePerPerson;
	
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String inputAddress;
	
	@Column(nullable = false)
	private int numberOfPeople;
	
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String typeOfAccommodation;
	
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String category;
	
	@ManyToMany
    @JoinTable(
            name = "accommodation_encoded_facilities",
            joinColumns = {@JoinColumn(name = "accommodation_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "encoded_facilities_name", referencedColumnName = "name")})
	@BatchSize(size = 20)
    private Set<EncodedFacility> additionalFacilities = new HashSet<>();
	
	public Accommodation() {
		
	}
	
	public Accommodation(Date startDateAvailable, Date endDateAvailable, String name,
			@Size(min = 1, max = 50) String inputAddress, int numberOfPeople,
			@Size(min = 1, max = 50) String typeOfAccommodation, @Size(min = 1, max = 50) String category,
			Set<EncodedFacility> additionalFacilities) {
		super();
		this.startDateAvailable = startDateAvailable;
		this.endDateAvailable = endDateAvailable;
		this.name = name;
		this.inputAddress = inputAddress;
		this.numberOfPeople = numberOfPeople;
		this.typeOfAccommodation = typeOfAccommodation;
		this.category = category;
		this.additionalFacilities = additionalFacilities;
	}

	public Date getStartDateAvailable() {
		return startDateAvailable;
	}

	public void setStartDateAvailable(Date startDateAvailable) {
		this.startDateAvailable = startDateAvailable;
	}

	public Date getEndDateAvailable() {
		return endDateAvailable;
	}


	public void setEndDateAvailable(Date endDateAvailable) {
		this.endDateAvailable = endDateAvailable;
	}

	public String getInputAddress() {
		return inputAddress;
	}

	public void setInputAddress(String inputAddress) {
		this.inputAddress = inputAddress;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getTypeOfAccommodation() {
		return typeOfAccommodation;
	}

	public void setTypeOfAccommodation(String typeOfAccommodation) {
		this.typeOfAccommodation = typeOfAccommodation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<EncodedFacility> getAdditionalFacilities() {
		return additionalFacilities;
	}

	public void setAdditionalFacilities(Set<EncodedFacility> additionalFacilities) {
		this.additionalFacilities = additionalFacilities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPricePerPerson() {
		return pricePerPerson;
	}

	public void setPricePerPerson(float pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}

	@Override
	public String toString() {
		return "Accommodation [id=" + id + ", startDateAvailable=" + startDateAvailable + ", endDateAvailable="
				+ endDateAvailable + ", name=" + name + ", pictures=" + pictures + ", description=" + description
				+ ", pricePerPerson=" + pricePerPerson + ", inputAddress=" + inputAddress + ", numberOfPeople="
				+ numberOfPeople + ", typeOfAccommodation=" + typeOfAccommodation + ", category=" + category
				+ ", additionalFacilities=" + additionalFacilities + "]";
	}

}
