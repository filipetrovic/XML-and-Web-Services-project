package ftn.xmlws.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.EncodedAccommodationType;
import ftn.xmlws.project.beans.EncodedFacilityOther;
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
	List<EncodedFacilityOther> getAllFacilities();
	EncodedFacilityOther getFacility(Long facilityId);
	Boolean addFacility(EncodedFacilityOther facility);
	Boolean deleteFacility(EncodedFacilityOther facility );
	Boolean editFacility(EncodedFacilityOther facility );
	
}
