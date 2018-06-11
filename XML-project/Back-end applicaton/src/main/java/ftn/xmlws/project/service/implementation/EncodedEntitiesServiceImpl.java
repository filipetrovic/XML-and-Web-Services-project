package ftn.xmlws.project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.repository.EncodedAccommodationTypeRepository;
import ftn.xmlws.project.repository.EncodedFacilityRepository;
import ftn.xmlws.project.repository.EncodedStarRatingRepository;

@Service
public class EncodedEntitiesServiceImpl {
	@Autowired EncodedStarRatingRepository starRatingRepository;
	@Autowired EncodedAccommodationTypeRepository accommodationTypeRepository;
	@Autowired EncodedFacilityRepository facilityRepository;
	
}
