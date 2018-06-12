package ftn.xmlws.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.beans.EncodedAccommodationType;
import ftn.xmlws.project.beans.EncodedFacilityOther;
import ftn.xmlws.project.beans.EncodedStarRating;
import ftn.xmlws.project.service.EncodedEntitiesService;
import ftn.xmlws.project.web.dto.EncodedFacility;


@RestController
@CrossOrigin
@RequestMapping("/api/encoded")
public class EncodedEntitiesController {
	
	@Autowired EncodedEntitiesService service;
	
	//============================================================== Accomodation type ===================================================================
	
	@GetMapping("/getAllAccommodationTypes")
	public ResponseEntity<List<EncodedAccommodationType>> getAllAccommodationTypes() {
		return new ResponseEntity<List<EncodedAccommodationType>>(service.getAllAccommodationTypes(),HttpStatus.OK);
	}
	
	@GetMapping("/getAccommodationType")
	public ResponseEntity<EncodedAccommodationType> getAccommodationType(@RequestParam("typeId") Long typeId){
		return new ResponseEntity<EncodedAccommodationType>(service.getAccomodationType(typeId), HttpStatus.OK);
	}
	
	@PostMapping("/addAccommodationType")
	public ResponseEntity<Boolean> addAccommodationType(@RequestParam("typeName") String typeName  ) {
		EncodedAccommodationType a = new EncodedAccommodationType();
		a.setTypeName(typeName);
		return new ResponseEntity<Boolean>(service.addAccommodationType(a), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteAccommodationType")
	public ResponseEntity<Boolean> deleteAccommodationType(@RequestBody EncodedAccommodationType type){
		return new ResponseEntity<Boolean>(service.deleteAccomodationType(type), HttpStatus.OK);
	}
	
	@PutMapping("/editAccommodationType")
	public ResponseEntity<Boolean> editAccommodationType(@RequestBody EncodedAccommodationType type){
		return new ResponseEntity<Boolean>(service.editAccommodationType(type), HttpStatus.OK);
	}
	
	//============================================================== Star Rating ===================================================================
	
	@GetMapping("/getAllStarRatings")
	public ResponseEntity<List<EncodedStarRating>> getAllStarRatings() {
		return new ResponseEntity<List<EncodedStarRating>>(service.getAllStarRatings(),HttpStatus.OK);
	}
	
	@GetMapping("/getStarRating")
	public ResponseEntity<EncodedStarRating> getStarRating(@RequestParam("ratingId") Long ratingId){
		return new ResponseEntity<EncodedStarRating>(service.getStarRating(ratingId), HttpStatus.OK);
	}
	
	@PostMapping("/addStarRating")
	public ResponseEntity<Boolean> addStarRating(@RequestParam("ratingName") String ratingName  ) {
		EncodedStarRating r = new EncodedStarRating();
		r.setRatingName(ratingName);
		return new ResponseEntity<Boolean>(service.addStarRating(r), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteStarRating")
	public ResponseEntity<Boolean> deleteStarRating(@RequestBody EncodedStarRating rating){
		return new ResponseEntity<Boolean>(service.deleteStarRating(rating), HttpStatus.OK);
	}
	
	@PutMapping("/editStarRating")
	public ResponseEntity<Boolean> editStarRating(@RequestBody EncodedStarRating rating){
		return new ResponseEntity<Boolean>(service.editStarRating(rating), HttpStatus.OK);
	}
	
	
	
	//============================================================== Facility ===================================================================
	
	@GetMapping("/getAllFacilities")
	public ResponseEntity<List<EncodedFacilityOther>> getAllFacilities() {
		System.out.println("Pogodio sam getAllFacilities u back-end app");
		return new ResponseEntity<List<EncodedFacilityOther>>(service.getAllFacilities(),HttpStatus.OK);
	}
	
	@GetMapping("/getFacility")
	public ResponseEntity<EncodedFacilityOther> getFacility(@RequestParam("facilityId") Long facilityId){
		System.out.println("Pogodio sam getFacility u back-end app");
		return new ResponseEntity<EncodedFacilityOther>(service.getFacility(facilityId), HttpStatus.OK);
	}
	
	@PostMapping("/addFacility")
	public ResponseEntity<Boolean> addFacility(@RequestBody EncodedFacility facility  ) { //treba da prosledim samo parametar facilityName
		EncodedFacilityOther f= new EncodedFacilityOther();
		f.setFacilityName(facility.getFacilityName());
		return new ResponseEntity<Boolean>(service.addFacility(f), HttpStatus.CREATED);
	}
	
	@PostMapping("/deleteFacility")
	public ResponseEntity<Boolean> deleteFacility(@RequestBody EncodedFacility facility){
		EncodedFacilityOther f = new EncodedFacilityOther();
		f.setFacilityId(facility.getFacilityId());
		f.setFacilityName(facility.getFacilityName());
		System.out.println(f.getFacilityId());
		
		return new ResponseEntity<Boolean>(service.deleteFacility(f), HttpStatus.OK);
	}
	
	@PutMapping("/editFacility")
	public ResponseEntity<Boolean> editFacility(@RequestBody EncodedFacilityOther facility){
		return new ResponseEntity<Boolean>(service.editFacility(facility), HttpStatus.OK);
	}
	
	
}
