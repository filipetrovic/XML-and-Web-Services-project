package ftn.xmlws.project.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.ws.rs.DefaultValue;


@Entity
@Table(name = "Rating")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String comment;
	
	@Column(nullable = false)
	private int value;
	
	@Column(nullable = false)
	private Long reservationId;
	
	@Column(nullable = false)
	private Long accommodationId;
	
	@Column
	@DefaultValue("b'0'")
	private boolean approved;
	
	@Version
	@DefaultValue("0")
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
