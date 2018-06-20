package ftn.xmlws.project.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "check_in_date", nullable = false)
	private Date checkInDate;
	
	@Column(name = "check_out_date", nullable = false)
	private Date checkOutDate;
	
	@Column
	private boolean arrivalConfirmed;
	
	@Column
	private float priceOfReservation;
	
    @ManyToOne(optional = false)
    @JoinColumn(name="user_id")
    @NotNull
    private User user;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="accommodation_id", nullable=false)
    private Accommodation accommodation;
	
	public Reservation() {
		this.arrivalConfirmed = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public boolean isArrivalConfirmed() {
		return arrivalConfirmed;
	}

	public void setArrivalConfirmed(boolean arrivalConfirmed) {
		this.arrivalConfirmed = arrivalConfirmed;
	}

	public float getPriceOfReservation() {
		return priceOfReservation;
	}

	public void setPriceOfReservation(float priceOfReservation) {
		this.priceOfReservation = priceOfReservation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
