package ftn.xmlws.project.web.dto;

import java.sql.Date;

public class ReservationDTO {


	private Date checkInDate;
	private Date checkOutDate;
	private float priceOfReservation;
    private String username;
    private Long accommodationId;
    
    public ReservationDTO() {
    	
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

	public float getPriceOfReservation() {
		return priceOfReservation;
	}

	public void setPriceOfReservation(float priceOfReservation) {
		this.priceOfReservation = priceOfReservation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getAccommodationId() {
		return accommodationId;
	}

	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}

	@Override
	public String toString() {
		return "ReservationDTO [checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", priceOfReservation="
				+ priceOfReservation + ", username=" + username + ", accommodationId=" + accommodationId + "]";
	}
    
}
