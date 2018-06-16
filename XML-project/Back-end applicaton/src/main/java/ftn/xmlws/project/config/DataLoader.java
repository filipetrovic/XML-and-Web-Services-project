package ftn.xmlws.project.config;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.repository.AccommodationRepository;
import ftn.xmlws.project.repository.EncodedFacilityRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private EncodedFacilityRepository encodedFacilityRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		insertIntoAccommodations();
	}
	
	private void insertIntoAccommodations() {
		
//		EncodedFacility ef = new EncodedFacility();
//		ef.setName("WiFi");
//		
//		EncodedFacility ef1= new EncodedFacility();
//		ef1.setName("TV");
//		
//		EncodedFacility ef2 = new EncodedFacility();
//		ef2.setName("Restroom");
//		
//		EncodedFacility ef3 = new EncodedFacility();
//		ef3.setName("Board");
//		
//		
//		encodedFacilityRepository.save(ef);
//		encodedFacilityRepository.save(ef1);
//		encodedFacilityRepository.save(ef2);
//		encodedFacilityRepository.save(ef3);
		
		Set<EncodedFacility> additionalFacilities = new HashSet<>();
		additionalFacilities.add(encodedFacilityRepository.findOneById((long)1));
		additionalFacilities.add(encodedFacilityRepository.findOneById((long)2));
		
		Accommodation ac = new Accommodation(
				new Date(0),
				new Date(1),
				"Apartmani Jancic",
				"Smederevo",
				4,
				"appartment",
				"5 stars",
				additionalFacilities);
		
		accommodationRepository.save(ac);
		
		Set<EncodedFacility> additionalFacilities1 = new HashSet<>();
		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)3));
		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)4));
		
		
		
		Accommodation ac1 = new Accommodation(
				new Date(0),
				new Date(1),
				"Hotel Baosici",
				"Crna Gora",
				2,
				"hotel",
				"3 stars",
				additionalFacilities1);
		
		accommodationRepository.save(ac1);
	}

}
