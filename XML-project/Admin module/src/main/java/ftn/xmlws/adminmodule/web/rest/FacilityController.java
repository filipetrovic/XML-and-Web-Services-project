package ftn.xmlws.adminmodule.web.rest;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ftn.xmlws.adminmodule.beans.EncodedFacility;


@RestController
public class FacilityController {
	
	@PostMapping("/addFacility")
	public ResponseEntity<Boolean> addFacility(@RequestBody EncodedFacility facility){

		RestTemplate restTemplate = new RestTemplate();
		Boolean addFacilityResponse = restTemplate.postForObject("http://localhost:8080/api/encoded/addFacility", facility, Boolean.class);

//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.postForObject("http://localhost:8080/api/encoded/addFacility", facility, Facility.class);
		
//		RestTemplate template = new RestTemplate();
//		Facility facilityResponse = template.getForObject("http://localhost:8080/api/encoded/getAllFacilities", Facility.class);
		
		
//		RestTemplate restTemplate = new RestTemplate();
//		 
//		HttpEntity<EncodedFacility> request = new HttpEntity<>(facility);
//		Boolean boo = restTemplate.postForObject("http://localhost:8080/api/encoded/addFacility", request, Boolean.class);
		

		
		System.out.println("VRATIO MI JE:" + addFacilityResponse);
		System.out.println("Pogodio sam addFacility u admin module");
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@PostMapping("/deleteFacility")
	public ResponseEntity<Boolean> deleteFacility(@RequestBody EncodedFacility facility){
		RestTemplate restTemplate = new RestTemplate();
		Boolean deleteFacilityResponse = restTemplate.postForObject("http://localhost:8080/api/encoded/deleteFacility", facility, Boolean.class);
		System.out.println("VRATIO MI JE:" + deleteFacilityResponse);
//		
//		RestTemplate restTemplate = new RestTemplate();
//        CustomObjectMapper mapper = new CustomObjectMapper();
//        try {
//            ResponseEntity<Person> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Person.class, uriVariables);
//            return responseEntity.getBody();
//        } catch (RestClientException e) {
//            System.out.println(mapper.writeValueAsString(person));
//            throw e;
//        }
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
