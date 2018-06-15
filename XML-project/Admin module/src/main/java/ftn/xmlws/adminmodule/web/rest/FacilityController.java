package ftn.xmlws.adminmodule.web.rest;



import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ftn.xmlws.adminmodule.beans.AccommodationType;
import ftn.xmlws.adminmodule.beans.Facility;
import ftn.xmlws.adminmodule.beans.StarRating;


@RestController
@CrossOrigin
public class FacilityController {
	
	//============================================================== Accommodation type ===================================================================
	
	@GetMapping("/getAllAccommodationTypes")
	public ResponseEntity<List<AccommodationType>> getAllAccommodationTypes(){
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<AccommodationType[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/encoded/getAllAccommodationTypes", AccommodationType[].class);
			AccommodationType[] types = responseEntity.getBody();
			
			return new ResponseEntity<List<AccommodationType>>(Arrays.asList(types),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/getAllAccommodationTypes");
			return new ResponseEntity<List<AccommodationType>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAccommodationType")
	public ResponseEntity<AccommodationType> getAccommodationType(@RequestParam("id") Long typeId){
		RestTemplate restTemplate = new RestTemplate();
		
		URI targetUrl= UriComponentsBuilder.fromUriString("http://localhost:8080")  
		    .path("/api/encoded/getAccommodationType")                           
		    .queryParam("id", typeId)                               
		    .build()                                                 
		    .encode()                                                
		    .toUri();                                                
		
		try {
			AccommodationType f = restTemplate.getForObject(targetUrl, AccommodationType.class);
			return new ResponseEntity<AccommodationType>(f, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occurred while trying getFacility from back-end database");
			return new ResponseEntity<AccommodationType>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addAccommodationType")
	public ResponseEntity<Boolean> addAccommodationType(@RequestParam("name") String  typeName){
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("name", typeName);
		
		try {
			Boolean response = restTemplate.postForObject("http://localhost:8080/api/encoded/addAccommodationType", parametersMap, Boolean.class);
			return new ResponseEntity<Boolean>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/addAccommodationType");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteAccommodationType")
	public ResponseEntity<Boolean> deleteAccommodationType(@RequestBody AccommodationType accommodationType){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<AccommodationType> entity = new HttpEntity<>(accommodationType);
		
        try {
        	
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/encoded/deleteAccommodationType", 
            														HttpMethod.DELETE, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	System.out.println("An error occurred while trying to access back-end-module/deleteAccommodationType");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
		
	}
	
	@PutMapping("/editAccommodationType")
	public ResponseEntity<Boolean> editAccommodationType(@RequestBody AccommodationType accommodationType){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<AccommodationType> entity = new HttpEntity<>(accommodationType);
		
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/encoded/editAccommodationType", 
            														HttpMethod.PUT, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	System.out.println("An error occurred while trying to access back-end-module/editAccommodationType");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	//============================================================== Star rating ===================================================================
	
	@GetMapping("/getAllStarRatings")
	public ResponseEntity<List<StarRating>> getAllStarRatings(){
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<StarRating[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/encoded/getAllStarRatings", StarRating[].class);
			StarRating[] starRatings = responseEntity.getBody();
			
			return new ResponseEntity<List<StarRating>>(Arrays.asList(starRatings),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/getAllStarRatings");
			return new ResponseEntity<List<StarRating>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getStarRating")
	public ResponseEntity<StarRating> getStarRating(@RequestParam("id") Long ratingId){
		RestTemplate restTemplate = new RestTemplate();
		
		URI targetUrl= UriComponentsBuilder.fromUriString("http://localhost:8080")  
		    .path("/api/encoded/getStarRating")                           
		    .queryParam("id", ratingId)                               
		    .build()                                                 
		    .encode()                                                
		    .toUri();                                                
		
		try {
			StarRating f = restTemplate.getForObject(targetUrl, StarRating.class);
			return new ResponseEntity<StarRating>(f, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occurred while trying getFacility from back-end database");
			return new ResponseEntity<StarRating>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addStarRating")
	public ResponseEntity<Boolean> addStarRating(@RequestParam("name") String  ratingName){
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("name", ratingName);
		
		try {
			Boolean response = restTemplate.postForObject("http://localhost:8080/api/encoded/addStarRating", parametersMap, Boolean.class);
			return new ResponseEntity<Boolean>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/addStarRating");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteStarRating")
	public ResponseEntity<Boolean> deleteStarRating(@RequestBody StarRating starRating){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<StarRating> entity = new HttpEntity<>(starRating);
		
        try {
        	
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/encoded/deleteStarRating", 
            														HttpMethod.DELETE, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	System.out.println("An error occurred while trying to access back-end-module/deleteStarRating");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
		
	}
	
	@PutMapping("/editStarRating")
	public ResponseEntity<Boolean> editStarRating(@RequestBody StarRating starRating){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<StarRating> entity = new HttpEntity<>(starRating);
		System.out.println("stiglo: " + starRating.getName());
		
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/encoded/editStarRating", 
            														HttpMethod.PUT, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	System.out.println("An error occurred while trying to access back-end-module/editStarRating");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	//============================================================== Facility ===================================================================
	
	@GetMapping("/getAllFacilities")
	public ResponseEntity<List<Facility>> getAllFacilities(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<Facility[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/encoded/getAllFacilities", Facility[].class);
			Facility[] facilities = responseEntity.getBody();
			return new ResponseEntity<List<Facility>>(Arrays.asList(facilities),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/getAllFacilities");
			return new ResponseEntity<List<Facility>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getFacility")
	public ResponseEntity<Facility> getFacility(@RequestParam("id") Long facilityId){
		RestTemplate restTemplate = new RestTemplate();
		
		URI targetUrl= UriComponentsBuilder.fromUriString("http://localhost:8080")  
		    .path("/api/encoded/getFacility")                           
		    .queryParam("id", facilityId)                               
		    .build()                                                 
		    .encode()                                                
		    .toUri();                                                
		
		try {
			Facility f = restTemplate.getForObject(targetUrl, Facility.class);
			return new ResponseEntity<Facility>(f, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occurred while trying getFacility from back-end database");
			return new ResponseEntity<Facility>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addFacility")
	public ResponseEntity<Boolean> addFacility(@RequestParam("name") String  facilityName){
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("name", facilityName);
		
		try {
			Boolean response = restTemplate.postForObject("http://localhost:8080/api/encoded/addFacility", parametersMap, Boolean.class);
			return new ResponseEntity<Boolean>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/addFacility");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteFacility")
	public ResponseEntity<Boolean> deleteFacility(@RequestBody Facility facility){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Facility> entity = new HttpEntity<>(facility);
		
        try {
        	
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/encoded/deleteFacility", 
            														HttpMethod.DELETE, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	System.out.println("An error occurred while trying to access back-end-module/deleteFacility");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
		
	}
	
	@PutMapping("/editFacility")
	public ResponseEntity<Boolean> editFacility(@RequestBody Facility facility){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Facility> entity = new HttpEntity<>(facility);
		
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/encoded/editFacility", 
            														HttpMethod.PUT, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	System.out.println("An error occurred while trying to access back-end-module/editFacility");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	

}
