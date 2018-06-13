package ftn.xmlws.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.EncodedAccommodationType;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.EncodedStarRating;

@Service
public interface EncodedEntitiesService {
	//AccomodationTypes
	List<EncodedAccommodationType> getAllAccommodationTypes();
	EncodedAccommodationType getAccomodationType(Long typeId);
	Boolean addAccommodationType(EncodedAccommodationType type);
	Boolean deleteAccomodationType(EncodedAccommodationType type );
	Boolean editAccommodationType(EncodedAccommodationType type );
	
	//StarRating
	List<EncodedStarRating> getAllStarRatings();
	EncodedStarRating getStarRating(Long ratingId);
	Boolean addStarRating(EncodedStarRating rating);
	Boolean deleteStarRating(EncodedStarRating rating );
	Boolean editStarRating(EncodedStarRating rating );
	
	//Facility
	List<EncodedFacility> getAllFacilities();
	EncodedFacility getFacility(Long facilityId);
	Boolean addFacility(EncodedFacility facility);
	Boolean deleteFacility(EncodedFacility facility );
	Boolean editFacility(EncodedFacility facility );
	
}
