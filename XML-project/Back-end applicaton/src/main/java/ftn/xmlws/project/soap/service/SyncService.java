package ftn.xmlws.project.soap.service;


import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.service.EncodedEntitiesService;
import ftn.xmlws.project.soap.service.mapper.EntityMapper;

import java.util.List;

/**
 * Service providing buissness logic
 * @author sansajn
 */
@Service
public class SyncService {

    @Autowired
    private EncodedEntitiesService encodedEntitiesService;

    @Autowired
    private EntityMapper entityMapper;

    public List<com.xmlws.ftn.soap.EncodedAccommodationType> getTypesAsXML() {
        return entityMapper.transformListEncodedAccommodationTypesEntityToXML(encodedEntitiesService.getAllAccommodationTypes());
    }

    public List<com.xmlws.ftn.soap.EncodedFacility> getFacilitysAsXML() {
        return entityMapper.transformListEncodedFacilityToXML(encodedEntitiesService.getAllFacilities());
    }

    public List<com.xmlws.ftn.soap.EncodedStarRating> getStarRatingAsXML() {
        return entityMapper.transformListEncodedStarRatingToXML(encodedEntitiesService.getAllStarRatings());
    }

    //DODATI GET ALL RESERVATION umesto null
    public List<com.xmlws.ftn.soap.EncodedReservation> getReservationAsXML() {
        return entityMapper.transferListReservationToXML(null);
    }

    public List<Accommodation> getAccomodationFromXml(List<com.xmlws.ftn.soap.EncodedAccomodation> encodedList) {
        return  entityMapper.transferListFromXMLTOAccommodation(encodedList);
    }

    //kiks
    public List<Reservation> getReservationFromXML(List<com.xmlws.ftn.soap.EncodedReservation> encodedList) {
        return entityMapper.transferListFromXMLToReservation(encodedList);
    }

    public List<PricePerInterval> getPricePerIntervalFromXml(List<com.xmlws.ftn.soap.EncodedPriceList> encodedList) {
        return entityMapper.transferListFromXMLToPricePerInterval(encodedList);
    }

    public List<HelperDTO> getHelperDTOFromXML(List<com.xmlws.ftn.soap.EncodedRequest> encodedList) {
        return entityMapper.transferListFromXMLToHelperDTO(encodedList);
    }

}
