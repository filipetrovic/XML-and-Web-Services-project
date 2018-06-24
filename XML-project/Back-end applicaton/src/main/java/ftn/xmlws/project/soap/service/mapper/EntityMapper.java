package ftn.xmlws.project.soap.service.mapper;


import ftn.xmlws.project.beans.*;
import ftn.xmlws.project.soap.service.HelperDTO;
import ftn.xmlws.project.soap.service.PricePerInterval;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for transforming objects from database to XML
 * and XML to database models
 */
@Component
public class EntityMapper {


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

    public HelperDTO transferToReservationState(generated.soap.com.xmlws.ftn.soap.EncodedRequest encodedHelper) {
        HelperDTO helperDTO = new HelperDTO();
        return helperDTO;
    }

    public List<HelperDTO> transferListFromXMLToHelperDTO(List<generated.soap.com.xmlws.ftn.soap.EncodedRequest> encodedList) {
        return encodedList.stream()
                .map( object -> {
                    return transferToReservationState(object);
                })
                .collect(Collectors.toList());
    }

    public PricePerInterval transferToPricePerInterval(generated.soap.com.xmlws.ftn.soap.EncodedPriceList encodedPriceList) {
        PricePerInterval object = new PricePerInterval();
        return  object;
    }

    public List<PricePerInterval> transferListFromXMLToPricePerInterval(List<generated.soap.com.xmlws.ftn.soap.EncodedPriceList> encodedList) {
        return encodedList.stream()
                .map( object -> {
                    return transferToPricePerInterval(object);
                })
                .collect(Collectors.toList());
    }


}
