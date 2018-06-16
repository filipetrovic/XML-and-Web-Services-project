package ftn.xmlws.project.web.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.service.AccommodationService;
import ftn.xmlws.project.web.dto.AccomodationSearchParamsDTO;

@RestController
@RequestMapping(value = "/api/client")
public class ClientModuleController {
	
	@Autowired
	private AccommodationService accommodationService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<ArrayList<Accommodation>> search(@RequestBody AccomodationSearchParamsDTO accomodationSearchParamsDTO) {
		
		System.out.println(accomodationSearchParamsDTO  + " ovo je search dobijen DTO");

		System.out.println(accommodationService.getAllAccommodations());
		
		
		
		return new ResponseEntity<ArrayList<Accommodation>>(accommodationService.getAllAccommodations(), HttpStatus.OK);
		
	}
	
//	@RequestMapping(value = "/search1", method = RequestMethod.GET, produces="application/json")
//	public ResponseEntity testGet() {
//		
//		System.out.println(" ovo je search dobijen DTO");
//
//		return new ResponseEntity("gsesgse", HttpStatus.OK);
//		
//		
//	}

}
