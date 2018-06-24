package ftn.xmlws.soap.service.mapper;

import com.xmlws.ftn.soap.*;
import ftn.xmlws.soap.domain.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class Mapper {

    public List<Addition> fromCoreToAdditionList(List<com.xmlws.ftn.soap.EncodedFacility> fromCoreList) {
        return fromCoreList
                .stream()
                .map( object -> {
                    return fromCoreToAddition(object);
                })
                .collect(Collectors.toList());
    }

    public Addition fromCoreToAddition(com.xmlws.ftn.soap.EncodedFacility fromCore) {
        Addition object = new Addition(fromCore.getName());
        object.setId(fromCore.getId());
        return object;
    }

    public Category fromCoreToCategory(com.xmlws.ftn.soap.EncodedAccommodationType fromCore) {
        Category object = new Category(fromCore.getName());
        object.setId(fromCore.getId());
        return object;
    }

    public List<Category> fromCoreToCategoryList(List<com.xmlws.ftn.soap.EncodedAccommodationType> fromCoreList) {
        return fromCoreList
                .stream()
                .map( object -> {
                    return fromCoreToCategory(object);
                })
                .collect(Collectors.toList());
    }

    public StarRating fromCoreToStarRating(com.xmlws.ftn.soap.EncodedStarRating fromCore) {
        StarRating object = new StarRating(fromCore.getName());
        object.setId(fromCore.getId());
        return object;
    }

    public List<StarRating> fromCoreToStarRatingList(List<com.xmlws.ftn.soap.EncodedStarRating> fromCoreList) {
        return fromCoreList
                .stream()
                .map( object -> {
                    return fromCoreToStarRating(object);
                })
                .collect(Collectors.toList());
    }

    public Reservation fromCoreToReservation(EncodedReservation encodedReservation) {
        Reservation reservation = new Reservation();
        reservation.setArrivalConfirmed(Boolean.getBoolean(encodedReservation.getArrivalConfirmed()));
        reservation.setCheckInDate(Date.valueOf(encodedReservation.getCheckInDate()));
        reservation.setCheckOutDate(Date.valueOf(encodedReservation.getCheckOutDate()));
        reservation.setId(encodedReservation.getId());
        reservation.setPriceOfReservation(Float.valueOf(encodedReservation.getPriceOfReservation()));
        Set<Message> temp = new HashSet<>();
        encodedReservation.getMessages().stream().forEach(mess -> {
            Message tempMessage = new Message();
            tempMessage.setMessage(mess);
            temp.add(tempMessage);
        });
        reservation.setMessages(temp);
        reservation.setUsername(encodedReservation.getUser());
        return reservation;
    }

    public List<Reservation> fromCoreToReservationList(List<EncodedReservation> fromCoreList) {
        return fromCoreList
                .stream()
                .map( object -> {
                    return fromCoreToReservation(object);
                })
                .collect(Collectors.toList());
    }

    public EncodedAccomodation transformAccomodationToXML(Accomodation accomodation) {
        EncodedAccomodation object = new EncodedAccomodation();
        object.setAddress(accomodation.getCity() + " " + accomodation.getAddress());
        object.setCategory(accomodation.getCategory().getName());
        object.setCity(accomodation.getDescription());
        object.setEndDateAvailable(accomodation.getEndDateAvailable().toString());
        object.setId(accomodation.getId());
        object.setImage(accomodation.getImage());
        object.setName(accomodation.getName());
        object.setNumber(String.valueOf(accomodation.getName()));
        object.setStarRating(accomodation.getStarRating().getName());
        object.setStartDateAvailable(accomodation.getStartDateAvailable().toString());
        accomodation.getAdditions().stream().forEach(additiona -> object.getAdditions().add(additiona.getName()));
        return object;
    }

    public List<EncodedAccomodation> transformListAccomodationToXML(List<Accomodation> accomodations) {
        return accomodations
                .stream()
                .map( object -> {
                    return transformAccomodationToXML(object);
                })
                .collect(Collectors.toList());
    }

    public EncodedPriceList transformPricePerIntervalToXML(PriceForPeriod priceForPeriod) {
        EncodedPriceList object = new EncodedPriceList();
        object.setId(priceForPeriod.getAccomodation().getId());
        object.setFrom(priceForPeriod.getStartDate().toString());
        object.setTo(priceForPeriod.getEndDate().toString() + ";" + priceForPeriod.getAccomodation().getName());
        object.setPrice(String.valueOf(priceForPeriod.getPrice()));
        return object;
    }

    public List<EncodedPriceList> transformListPricePerIntervalToXML(List<PriceForPeriod> priceForPeriods) {
        return priceForPeriods
                .stream()
                .map( object -> {
                    return transformPricePerIntervalToXML(object);
                })
                .collect(Collectors.toList());
    }

    public EncodedRequest transformEncodedRequestToXML(Reservation reservation) {
        EncodedRequest object = new EncodedRequest();
        object.setId(reservation.getId());
        object.setStatus(String.valueOf(reservation.isArrivalConfirmed()));
        reservation.getMessages().stream().forEach(mess ->  {
            object.getMessages().add(mess.getMessage());
            object.getMessageby().add(reservation.getUsername());
        });
        return object;
    }

    public List<EncodedRequest> transformEncodedRequestListToXML(List<Reservation> reservations) {
        return reservations
                .stream()
                .map( object -> {
                    return transformEncodedRequestToXML(object);
                })
                .collect(Collectors.toList());
    }



}
