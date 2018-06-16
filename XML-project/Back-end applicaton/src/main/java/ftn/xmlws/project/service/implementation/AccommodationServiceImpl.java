package ftn.xmlws.project.service.implementation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.repository.AccommodationRepository;
import ftn.xmlws.project.repository.EncodedFacilityRepository;
import ftn.xmlws.project.service.AccommodationService;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private EncodedFacilityRepository encodedFacilityRepository;
	
	@Override
	public ArrayList<Accommodation> getAllAccommodations() {

		return accommodationRepository.findAll();
	}

}
