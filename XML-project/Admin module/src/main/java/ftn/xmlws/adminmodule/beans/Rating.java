package ftn.xmlws.adminmodule.beans;


public class Rating {

	private Long id;
	private String comment;
	private int value;
	private Long reservationId;
	private Long accommodationId;
	private boolean approved;
	private int version;
	
	

	public Rating() {
		
	}
	
	public Rating(String comment, int value, Long reservationId, Long accommodationId, boolean approved) {
		super();
		this.comment = comment;
		this.value = value;
		this.reservationId = reservationId;
		this.accommodationId = accommodationId;
		this.approved = approved;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
	
	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
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

}
