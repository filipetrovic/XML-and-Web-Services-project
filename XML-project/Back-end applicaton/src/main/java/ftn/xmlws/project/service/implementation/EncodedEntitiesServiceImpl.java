package ftn.xmlws.project.service.implementation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.EncodedAccommodationType;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.EncodedStarRating;
import ftn.xmlws.project.repository.EncodedAccommodationTypeRepository;
import ftn.xmlws.project.repository.EncodedFacilityRepository;
import ftn.xmlws.project.repository.EncodedStarRatingRepository;
import ftn.xmlws.project.service.EncodedEntitiesService;

@Service
public class EncodedEntitiesServiceImpl implements EncodedEntitiesService {
	@Autowired EncodedStarRatingRepository starRatingRepository;
	@Autowired EncodedAccommodationTypeRepository accommodationTypeRepository;
	@Autowired EncodedFacilityRepository facilityRepository;
	
	//======================================================= Accommodation Type ==========================================================
	@Override
	public Boolean addAccommodationType(EncodedAccommodationType a) {
		try {
			accommodationTypeRepository.saveAndFlush(a);
			return true;
		} catch( Exception e) {
			System.out.println("Error occurred while writing AccomodationType to database");
			return false;
		}
		
	}

	@Override
	public Boolean deleteAccomodationType(EncodedAccommodationType type) {
		try {
			accommodationTypeRepository.delete(type);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while deleting AccomodationType from database");
			return false;
		}
		
		
	}

	@Override
	@Transactional()
	public Boolean editAccommodationType(EncodedAccommodationType type) {
		try { 
			accommodationTypeRepository.saveAndFlush(type);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while updating AccomodationType in database");
			return false;
		}
	}

	@Override
	public List<EncodedAccommodationType> getAllAccommodationTypes() {
		return accommodationTypeRepository.findAll();
	}

	@Override
	public EncodedAccommodationType getAccomodationType(Long typeId) {
		return accommodationTypeRepository.findOneById(typeId);
	}
	
	//================================================ Star Rating ==========================================================

	@Override
	public List<EncodedStarRating> getAllStarRatings() {
		return starRatingRepository.findAll();
	}

	@Override
	public EncodedStarRating getStarRating(Long ratingId) {
		return starRatingRepository.findOneById(ratingId);
	}

	@Override
	public Boolean addStarRating(EncodedStarRating rating) {
		try {
			starRatingRepository.saveAndFlush(rating);
			return true;
		} catch( Exception e) {
			System.out.println("Error occurred while writing StarRating to database");
			return false;
		}
	}

	@Override
	public Boolean deleteStarRating(EncodedStarRating rating) {
		try {
			starRatingRepository.delete(rating);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while deleting StarRating from database");
			return false;
		}
	}

	@Override
	@Transactional()
	public Boolean editStarRating(EncodedStarRating rating) {
		try { 
			starRatingRepository.saveAndFlush(rating);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while updating StarRating in database");
			return false;
		}
	}	
	//================================================ Facility ==========================================================
	
	@Override
	public List<EncodedFacility> getAllFacilities() {
		return facilityRepository.findAll();
	}

	@Override
	public EncodedFacility getFacility(Long facilityId) {
		return facilityRepository.findOneById(facilityId);
	}

	@Override
	public Boolean addFacility(EncodedFacility facility) {
		try {
			facilityRepository.saveAndFlush(facility);
			return true;
		} catch( Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while writing Facility to database");
			return false;
		}
	}

	@Override
	public Boolean deleteFacility(EncodedFacility facility) {
		try {
			facilityRepository.delete(facility);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while deleting Facility from database");
			return false;
		}
	}

	@Override
	@Transactional()
	public Boolean editFacility(EncodedFacility facility) {
		try { 
			facilityRepository.saveAndFlush(facility);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while updating Facility in database");
			return false;
		}
	}
}
