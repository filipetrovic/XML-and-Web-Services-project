package ftn.xmlws.project.web.dto;

public class MessageDTO {

	private String message;
	private boolean userIsSender;
	private Long reservationId;
	
	public MessageDTO() {
		
	}
	
	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isUserIsSender() {
		return userIsSender;
	}

	public void setUserIsSender(boolean userIsSender) {
		this.userIsSender = userIsSender;
	}
	
}
