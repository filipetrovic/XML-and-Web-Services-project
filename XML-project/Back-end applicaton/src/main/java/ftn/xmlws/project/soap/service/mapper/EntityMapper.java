package ftn.xmlws.project.soap.service.mapper;


import ftn.xmlws.project.beans.*;
import ftn.xmlws.project.soap.service.HelperDTO;
import ftn.xmlws.project.soap.service.PricePerInterval;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.EncodedAccommodationType;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.EncodedStarRating;
import ftn.xmlws.project.beans.Message;
import ftn.xmlws.project.beans.Reservation;
import ftn.xmlws.project.repository.EncodedAccommodationTypeRepository;
import ftn.xmlws.project.repository.EncodedFacilityRepository;
import ftn.xmlws.project.repository.EncodedStarRatingRepository;
import ftn.xmlws.project.repository.ReservationRepository;
import ftn.xmlws.project.soap.service.HelperDTO;
import ftn.xmlws.project.soap.service.PricePerInterval;
import generated.soap.com.xmlws.ftn.soap.EncodedReservation;

/**
 * Class for transforming objects from database to XML
 * and XML to database models
 */
@Component
public class EntityMapper {
	
	@Autowired
	private EncodedStarRatingRepository starRatingRepository;
	
	@Autowired
	private EncodedFacilityRepository facilityRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private EncodedAccommodationTypeRepository accommodationTypeRepository;

    public generated.soap.com.xmlws.ftn.soap.EncodedAccommodationType transformEncodedAccommodationTypesEntityToXML(EncodedAccommodationType encodedAccommodationType) {
        generated.soap.com.xmlws.ftn.soap.EncodedAccommodationType object = new generated.soap.com.xmlws.ftn.soap.EncodedAccommodationType();
        object.setId(encodedAccommodationType.getId());
        object.setName(encodedAccommodationType.getName());
        return object;
    }

    public List<generated.soap.com.xmlws.ftn.soap.EncodedAccommodationType> transformListEncodedAccommodationTypesEntityToXML(List<EncodedAccommodationType> encodedAccommodationType) {
        return encodedAccommodationType
                .stream()
                .map( object -> {
                    return transformEncodedAccommodationTypesEntityToXML(object);
                })
                .collect(Collectors.toList());
    }

    public generated.soap.com.xmlws.ftn.soap.EncodedFacility transformEncodedFacilityToXML(EncodedFacility encodedFacility) {
        generated.soap.com.xmlws.ftn.soap.EncodedFacility object = new generated.soap.com.xmlws.ftn.soap.EncodedFacility();
        object.setId(encodedFacility.getId());
        object.setName(encodedFacility.getName());
        return object;
    }

    public List<generated.soap.com.xmlws.ftn.soap.EncodedFacility> transformListEncodedFacilityToXML(List<EncodedFacility> encodedFacilities) {
        return encodedFacilities.stream()
                .map( object -> {
                    return transformEncodedFacilityToXML(object);
                })
                .collect(Collectors.toList());
    }

    public generated.soap.com.xmlws.ftn.soap.EncodedStarRating transformEncodedRatingStarToXML(EncodedStarRating encodedStarRating) {
        generated.soap.com.xmlws.ftn.soap.EncodedStarRating object = new generated.soap.com.xmlws.ftn.soap.EncodedStarRating();
        object.setId(encodedStarRating.getId());
        object.setName(encodedStarRating.getName());
        return object;
    }

    public List<generated.soap.com.xmlws.ftn.soap.EncodedStarRating> transformListEncodedStarRatingToXML(List<EncodedStarRating> encodedStarRating) {
        return encodedStarRating.stream()
                .map( object -> {
                    return transformEncodedRatingStarToXML(object);
                })
                .collect(Collectors.toList());
    }

    public List<Accommodation> transferListFromXMLTOAccommodation(List<generated.soap.com.xmlws.ftn.soap.EncodedAccomodation> encodedList) {
        return encodedList.stream()
                .map( object -> {
                    return transferFromXMLToAccommodation(object);
                })
                .collect(Collectors.toList());
    }

    public Accommodation transferFromXMLToAccommodation(generated.soap.com.xmlws.ftn.soap.EncodedAccomodation encodedAccomodation) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(encodedAccomodation.getName());
        accommodation.setNumberOfPeople(Integer.parseInt(encodedAccomodation.getNumber()));
        // city je opis
        accommodation.setDescription(encodedAccomodation.getCity());
        accommodation.setInputAddress(encodedAccomodation.getAddress());
        accommodation.setStartDateAvailable(java.sql.Date.valueOf(encodedAccomodation.getStartDateAvailable()));
        accommodation.setEndDateAvailable(java.sql.Date.valueOf(encodedAccomodation.getEndDateAvailable()));
        accommodation.setCategory(starRatingRepository.findOneByName(encodedAccomodation.getStarRating()));
        accommodation.setTypeOfAccommodation(accommodationTypeRepository.findOneByName(encodedAccomodation.getCategory()));
        accommodation.setPictures(encodedAccomodation.getImage());
        accommodation.setRating(0);
        
//        for(String a : encodedAccomodation.getAdditions())
//        {
//        	accommodation.getAdditionalFacilities().add(facilityRepository.findOneByName(a));
//        }
        	
        return accommodation;
    }

    public Reservation transferFromXMLToReservation(generated.soap.com.xmlws.ftn.soap.EncodedReservation encodedReservation) {
        Reservation reservation = new Reservation();
        return reservation;
    }

    public List<Reservation> transferListFromXMLToReservation(List<generated.soap.com.xmlws.ftn.soap.EncodedReservation> encodedReservation) {
        return encodedReservation.stream()
                .map( object -> {
                    return transferFromXMLToReservation(object);
                })
                .collect(Collectors.toList());
    }

    public List<generated.soap.com.xmlws.ftn.soap.EncodedReservation> transferListReservationToXML(List<Reservation> reservations) {
        return reservations.stream()
                .map( object -> {
                    return transferReservationToXML(object);
                })
                .collect(Collectors.toList());
    }

    public generated.soap.com.xmlws.ftn.soap.EncodedReservation transferReservationToXML(Reservation reservation) {
        generated.soap.com.xmlws.ftn.soap.EncodedReservation encodedReservation = new generated.soap.com.xmlws.ftn.soap.EncodedReservation();
        encodedReservation.setAccommodation(reservation.getAccommodation().getName());
        encodedReservation.setCheckInDate(reservation.getCheckInDate().toString());
        encodedReservation.setCheckOutDate(reservation.getCheckOutDate().toString());
        encodedReservation.setId(reservation.getId());
        encodedReservation.setPriceOfReservation(String.valueOf(reservation.getPriceOfReservation()));
        encodedReservation.setUser(reservation.getUser().getUsername());
        encodedReservation.setArrivalConfirmed(String.valueOf(reservation.isArrivalConfirmed()));
        return encodedReservation;
    }

    public Reservation transferToReservationState(generated.soap.com.xmlws.ftn.soap.EncodedRequest encodedHelper) {
        Reservation r = reservationRepository.findOneById(encodedHelper.getId());
        
        if(encodedHelper.getStatus().equals("true"))
        	r.setArrivalConfirmed(true);
        else
        	r.setArrivalConfirmed(false);
        
        Set<Message> messages = new HashSet<Message>();
        
        for(int i=0; i<encodedHelper.getMessages().size(); i++)
        {
        	Message m = new Message();
        	
        	m.setMessage(encodedHelper.getMessages().get(i));
        	m.setUserSender(encodedHelper.getMessageby().get(i).equals((r.getUser().getUsername())));
        	m.setReservation(r);

        	messages.add(m);
        }
        
        r.setMessages(messages);
        
        return r;
    }

    public List<Reservation> transferListFromXMLToHelperDTO(List<generated.soap.com.xmlws.ftn.soap.EncodedRequest> encodedList) {
        return encodedList.stream()
                .map( object -> {
                    return transferToReservationState(object);
                })
                .collect(Collectors.toList());
    }

    public ftn.xmlws.project.beans.PricePerInterval transferToPricePerInterval(generated.soap.com.xmlws.ftn.soap.EncodedPriceList encodedPriceList) {
        ftn.xmlws.project.beans.PricePerInterval object = new ftn.xmlws.project.beans.PricePerInterval();
        
        object.setAccomodationId(encodedPriceList.getId());
        object.setPrice(Float.parseFloat(encodedPriceList.getPrice()));
        object.setStartDate(Date.valueOf(encodedPriceList.getFrom()));
        object.setEndDate(Date.valueOf(encodedPriceList.getTo().split(";")[0]));

        return  object;
    }

    public List<ftn.xmlws.project.beans.PricePerInterval> transferListFromXMLToPricePerInterval(List<generated.soap.com.xmlws.ftn.soap.EncodedPriceList> encodedList) {
        return encodedList.stream()
                .map( object -> {
                    return transferToPricePerInterval(object);
                })
                .collect(Collectors.toList());
    }


}
