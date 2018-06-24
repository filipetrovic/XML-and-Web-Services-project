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
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.EncodedStarRating;
import ftn.xmlws.project.service.EncodedEntitiesService;


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
	public ResponseEntity<EncodedAccommodationType> getAccommodationType(@RequestParam("id") Long typeId){
		return new ResponseEntity<EncodedAccommodationType>(service.getAccomodationType(typeId), HttpStatus.OK);
	}
	
	@PostMapping("/addAccommodationType")
	public ResponseEntity<Boolean> addAccommodationType(@RequestParam("name") String typeName  ) {
		EncodedAccommodationType a = new EncodedAccommodationType();
		a.setName(typeName);
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
	public ResponseEntity<EncodedStarRating> getStarRating(@RequestParam("id") Long ratingId){
		return new ResponseEntity<EncodedStarRating>(service.getStarRating(ratingId), HttpStatus.OK);
	}
	
	@PostMapping("/addStarRating")
	public ResponseEntity<Boolean> addStarRating(@RequestParam("name") String ratingName  ) {
		EncodedStarRating r = new EncodedStarRating();
		r.setName(ratingName);
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
	public ResponseEntity<List<EncodedFacility>> getAllFacilities() {
		return new ResponseEntity<List<EncodedFacility>>(service.getAllFacilities(),HttpStatus.OK);
	}
	
	@GetMapping("/getFacility")
	public ResponseEntity<EncodedFacility> getFacility(@RequestParam("id") Long facilityId){
		System.out.println("Pogodio sam getFacility u back-end app");
		return new ResponseEntity<EncodedFacility>(service.getFacility(facilityId), HttpStatus.OK);
	}
	
	@PostMapping("/addFacility")
	public ResponseEntity<Boolean> addFacility(@RequestParam("name") String facilityName) { //treba da prosledim samo parametar facilityName
		EncodedFacility f= new EncodedFacility();
		f.setName(facilityName);
		return new ResponseEntity<Boolean>(service.addFacility(f), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteFacility")
	public ResponseEntity<Boolean> deleteFacility(@RequestBody EncodedFacility facility){
		
		
		return new ResponseEntity<Boolean>(service.deleteFacility(facility), HttpStatus.OK);
	}
	
	@PutMapping("/editFacility")
	public ResponseEntity<Boolean> editFacility(@RequestBody EncodedFacility facility){
		return new ResponseEntity<Boolean>(service.editFacility(facility), HttpStatus.OK);
	}
	
	
}
