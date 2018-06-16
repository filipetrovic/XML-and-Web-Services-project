package ftn.xmlws.project.web.dto;

import java.sql.Date;
import java.util.ArrayList;

public class AccomodationSearchParamsDTO {

	private Date checkInDate;
	private Date checkOutDate;
	private String inputAddress;
	private int numberOfPeople;
	private String typeOfAccomodation;
	private String category;
	private ArrayList<String> additionalServices;
	
	public AccomodationSearchParamsDTO() {
		
	}
	
	public AccomodationSearchParamsDTO(Date checkInDate, Date checkOutDate, String inputAddress, int numberOfPeople,
			String typeOfAccomodation, String category, ArrayList<String> additionalServices) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.inputAddress = inputAddress;
		this.numberOfPeople = numberOfPeople;
		this.typeOfAccomodation = typeOfAccomodation;
		this.category = category;
		this.additionalServices = additionalServices;
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

	public String getTypeOfAccomodation() {
		return typeOfAccomodation;
	}

	public void setTypeOfAccomodation(String typeOfAccomodation) {
		this.typeOfAccomodation = typeOfAccomodation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<String> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(ArrayList<String> additionalServices) {
		this.additionalServices = additionalServices;
	}

	@Override
	public String toString() {
		return "AccomodationSearchParamsDTO [checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", inputAddress=" + inputAddress + ", numberOfPeople=" + numberOfPeople + ", typeOfAccomodation="
				+ typeOfAccomodation + ", category=" + category + ", additionalServices=" + additionalServices + "]";
	}
	
	
	
}
