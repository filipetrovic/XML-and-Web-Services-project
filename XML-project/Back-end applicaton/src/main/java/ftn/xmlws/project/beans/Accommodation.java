package ftn.xmlws.project.beans;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column
	private float rating;
	
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String inputAddress;
	
	@Column(nullable = false)
	private int numberOfPeople;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="encoded_accomodation_types_id")
	private EncodedAccommodationType typeOfAccommodation;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="encoded_star_rating_id")
	private EncodedStarRating category;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="accommodation", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<Reservation> reservations;
	
	@ManyToMany(fetch = FetchType.EAGER)
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
			EncodedAccommodationType typeOfAccommodation, EncodedStarRating category,
			Set<EncodedFacility> additionalFacilities) {
		super();
		this.startDateAvailable = startDateAvailable;
		this.endDateAvailable = endDateAvailable;
		this.name = name;
		this.inputAddress = inputAddress;
		this.numberOfPeople = numberOfPeople;
		this.category = category;
		this.typeOfAccommodation = typeOfAccommodation;
		this.additionalFacilities = additionalFacilities;
	}

	public Accommodation(Date startDateAvailable, Date endDateAvailable, String name, String pictures,
			String description, float pricePerPerson, float rating, @Size(min = 1, max = 50) String inputAddress,
			int numberOfPeople, EncodedAccommodationType typeOfAccommodation,
			EncodedStarRating category, Set<Reservation> reservations,
			Set<EncodedFacility> additionalFacilities) {
		super();
		this.startDateAvailable = startDateAvailable;
		this.endDateAvailable = endDateAvailable;
		this.name = name;
		this.pictures = pictures;
		this.description = description;
		this.pricePerPerson = pricePerPerson;
		this.rating = rating;
		this.inputAddress = inputAddress;
		this.numberOfPeople = numberOfPeople;
		this.typeOfAccommodation = typeOfAccommodation;
		this.category = category;
		this.reservations = reservations;
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

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
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

	public EncodedAccommodationType getTypeOfAccommodation() {
		return typeOfAccommodation;
	}

	public void setTypeOfAccommodation(EncodedAccommodationType typeOfAccommodation) {
		this.typeOfAccommodation = typeOfAccommodation;
	}

	public EncodedStarRating getCategory() {
		return category;
	}

	public void setCategory(EncodedStarRating category) {
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
				+ ", reservations=" + reservations + ", additionalFacilities=" + additionalFacilities + "]";
	}

}
