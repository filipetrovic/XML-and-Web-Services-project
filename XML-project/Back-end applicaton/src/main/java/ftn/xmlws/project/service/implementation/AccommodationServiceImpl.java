package ftn.xmlws.project.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Accommodation;
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

}
