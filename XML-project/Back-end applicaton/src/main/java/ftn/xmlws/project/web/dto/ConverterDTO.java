package ftn.xmlws.project.web.dto;

import java.util.HashSet;
import java.util.Set;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.User;

public class ConverterDTO {

	public static final Accommodation convertToAccommodation(AccomodationSearchParamsDTO asp) {
		
		Accommodation a = new Accommodation();
		Set<EncodedFacility> additionalFacilities = new HashSet<>();
		
		for(String s:asp.getAdditionalServices())
		{
			EncodedFacility ef = new EncodedFacility();
			ef.setName(s);
			additionalFacilities.add(ef);
		}
		
		
		
		a.setAdditionalFacilities(additionalFacilities);
		a.setCategory(asp.getCategory());
		a.setInputAddress(asp.getInputAddress());
		a.setStartDateAvailable(asp.getCheckInDate());
		a.setEndDateAvailable(asp.getCheckOutDate());
		a.setNumberOfPeople(asp.getNumberOfPeople());
		a.setTypeOfAccommodation(asp.getTypeOfAccomodation());
		
		return a;
	}
	
	public static final User convertToUser(RegistrationUserDTO ru) {
		
		User u = new User();
		u.setEmail(ru.getEmail());
		u.setFirstName(ru.getFirstName());
		u.setLastName(ru.getLastName());
		u.setPassword(ru.getPassword());
		u.setUsername(ru.getUsername());
		
		return u;
	}
}
