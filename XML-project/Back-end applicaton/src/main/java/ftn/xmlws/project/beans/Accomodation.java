package ftn.xmlws.project.beans;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Accomodation")
public class Accomodation {

	private Date checkInDate;
	private Date checkOutDate;
	private String inputAddress;
	private int numberOfPeople;
	private String typeOfAccomodation;
	private String category;
	private ArrayList<String> additionalFacilities;
	
}
