package ftn.xmlws.project.web.rest;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.Rating;
import ftn.xmlws.project.beans.Reservation;
import ftn.xmlws.project.service.AccommodationService;
import ftn.xmlws.project.service.ReservationService;
import ftn.xmlws.project.web.dto.AccomodationSearchParamsDTO;
import ftn.xmlws.project.web.dto.ConverterDTO;
import ftn.xmlws.project.web.dto.ReservationDTO;

@RestController
@RequestMapping(value = "/api/client")
public class ClientAccommodationsController {
	
	@Autowired
	private AccommodationService accommodationService;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<ArrayList<Accommodation>> search(@RequestBody AccomodationSearchParamsDTO accomodationSearchParamsDTO) {
		
		System.out.println(accomodationSearchParamsDTO  + " ovo je search dobijen DTO");

		System.out.println(accommodationService.getAllAccommodations());
		
		if(accommodationService
				.getAccommodationsBasedOnSearchParams(ConverterDTO
				.convertToAccommodation(accomodationSearchParamsDTO)) == null)
				return new ResponseEntity<ArrayList<Accommodation>>(new ArrayList<Accommodation>(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ArrayList<Accommodation>>(accommodationService
				.getAccommodationsBasedOnSearchParams(ConverterDTO
				.convertToAccommodation(accomodationSearchParamsDTO)), HttpStatus.OK);
		
	}
	
	/************************************************************** RESERVATIONS **************************************************************/

	@RequestMapping(value = "/reserve", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Boolean> reserve(@RequestBody ReservationDTO r) {
	
		if(this.reservationService
				.makeReservation(ConverterDTO.convertToReservation(r), r.getUsername(), r.getAccommodationId()))
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		
		
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value = "/getReservations", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<Set<Reservation>> getReservations(@RequestParam("username") String username) {
		
		return new ResponseEntity<Set<Reservation>>(this.reservationService.getReservations(username), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/cancelReservation", method = RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<Set<Reservation>> cancelReservation(@RequestParam("reservationId") Long reservationId,
			@RequestParam("username") String username) {
		
		if(this.reservationService.cancelReservation(reservationId, username))
			return new ResponseEntity<Set<Reservation>>(this.reservationService.getReservations(username), HttpStatus.OK);
		
		return new ResponseEntity<Set<Reservation>>(this.reservationService.getReservations(username), HttpStatus.NO_CONTENT);
		
	}
	
	/************************************************************** RATINGS **************************************************************/
	
	@RequestMapping(value = "/getUserRatings", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<Set<Rating>> getUserRatings(@RequestParam("username") String username) {
		
		return new ResponseEntity<Set<Rating>>(this.reservationService.getUserRatings(username), HttpStatus.OK);
		
	}
	
}
