package ftn.xmlws.project.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.repository.AccommodationRepository;
import ftn.xmlws.project.service.AccommodationService;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Override
	public ArrayList<Accommodation> getAllAccommodations() {

		return accommodationRepository.findAll();
	}

	@Override
	public ArrayList<Accommodation> getAccommodationsBasedOnSearchParams(Accommodation accommodation) {
		
		ArrayList<Accommodation> matchedAccommodations = new ArrayList<Accommodation>();
		
		System.out.println(accommodationRepository.findAll());
		
		for(Accommodation a:accommodationRepository.findAll())
		{
			
			System.out.println(a.getId());
			// if the check in date is before the first available date
			if(accommodation.getStartDateAvailable().before(a.getStartDateAvailable()))
			{
				System.out.println(a.getName() + " continue on start date");
				System.out.println(a.getStartDateAvailable() + " searched: " + accommodation.getStartDateAvailable());
				continue;
			}
			
			// if the check out date is after the last available date
			if(accommodation.getEndDateAvailable().after(a.getEndDateAvailable()))
			{
				System.out.println(a.getName() + " continue on end date");
				System.out.println(a.getEndDateAvailable() + " searched: " + accommodation.getEndDateAvailable());
				continue;
			}
			
			// if the input address is not contained in search (smederevo, musicka 75), search is smederevo
			if(!a.getInputAddress().contains(accommodation.getInputAddress()))
			{
				System.out.println(a.getName() + " continue on input address");
				System.out.println(a.getInputAddress() + " searched: " + accommodation.getInputAddress());
				continue;
			}
			
			if(accommodation.getNumberOfPeople()>a.getNumberOfPeople())
			{
				System.out.println(a.getName() + " continue on getNumberOfPeople");
				System.out.println(a.getNumberOfPeople() + " searched: " + accommodation.getNumberOfPeople());
				continue;
			}
			
			if(!accommodation.getTypeOfAccommodation().equals(""))
				if(!accommodation.getTypeOfAccommodation().equals(a.getTypeOfAccommodation()))
				{
					System.out.println(a.getName() + " continue on getTypeOfAccommodation");
					System.out.println(a.getTypeOfAccommodation() + " searched: " + accommodation.getTypeOfAccommodation());
					continue;
				}
			
			if(!accommodation.getCategory().equals(""))
				if(!accommodation.getCategory().equals(a.getCategory()))
				{
					System.out.println(a.getName() + " continue on getCategory");
					System.out.println(a.getCategory() + " searched: " + accommodation.getCategory());
					continue;
				}
			
			for(EncodedFacility ef:accommodation.getAdditionalFacilities())
			{
				if(!a.getAdditionalFacilities().contains(ef))
				{
					System.out.println(a.getName() + " continue on getAdditionalFacilities");
					System.out.println(a.getAdditionalFacilities() + " searched: " + accommodation.getAdditionalFacilities());
					continue;
				}
			}		
			
			System.out.println("Successfully found : " + a);
			matchedAccommodations.add(a);
				
		}
		
		
		return matchedAccommodations;
	}

}
