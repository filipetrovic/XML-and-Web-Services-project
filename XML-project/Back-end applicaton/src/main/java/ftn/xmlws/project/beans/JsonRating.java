package ftn.xmlws.project.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonRating {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("comment")
	private String comment;
	
	@JsonProperty("value")
	private int value;
	
	@JsonProperty("reservation_id")
	private Long reservationId;
	
	@JsonProperty("accommodation_id")
	private Long accommodationId;
	
	@JsonProperty("approved")
	private boolean approved;

	@JsonProperty("version")
	private int version;
	
	public JsonRating() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getAccommodationId() {
		return accommodationId;
	}

	public void setAccommodationId(Long accommodationId) {
		this.accommodationId = accommodationId;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "JsonRating [id=" + id + ", comment=" + comment + ", value=" + value + ", reservationId=" + reservationId
				+ ", accommodationId=" + accommodationId + ", approved=" + approved + ", version=" + version + "]";
	}
	
}
