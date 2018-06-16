package ftn.xmlws.project.soap.service.mapper;

import ftn.xmlws.project.beans.EncodedAccommodationType;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.EncodedStarRating;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for transforming objects from database to XML
 * and XML to database models
 */
@Component
public class EntityMapper {


    public com.xmlws.ftn.soap_core.EncodedAccommodationType transformEncodedAccommodationTypesEntityToXML(EncodedAccommodationType encodedAccommodationType) {
        com.xmlws.ftn.soap_core.EncodedAccommodationType object = new com.xmlws.ftn.soap_core.EncodedAccommodationType();
        object.setId(encodedAccommodationType.getId());
        object.setName(encodedAccommodationType.getName());
        return object;
    }

    public List<com.xmlws.ftn.soap_core.EncodedAccommodationType> transformListEncodedAccommodationTypesEntityToXML(List<EncodedAccommodationType> encodedAccommodationType) {
        return encodedAccommodationType
                .stream()
                .map( object -> {
                    return transformEncodedAccommodationTypesEntityToXML(object);
                })
                .collect(Collectors.toList());
    }

    public com.xmlws.ftn.soap_core.EncodedFacility transformEncodedFacilityToXML(EncodedFacility encodedFacility) {
        com.xmlws.ftn.soap_core.EncodedFacility object = new com.xmlws.ftn.soap_core.EncodedFacility();
        object.setId(encodedFacility.getId());
        object.setName(encodedFacility.getName());
        return object;
    }

    public List<com.xmlws.ftn.soap_core.EncodedFacility> transformListEncodedFacilityToXML(List<EncodedFacility> encodedFacilities) {
        return encodedFacilities.stream()
                .map( object -> {
                    return transformEncodedFacilityToXML(object);
                })
                .collect(Collectors.toList());
    }

    public com.xmlws.ftn.soap_core.EncodedStarRating transformEncodedRatingStarToXML(EncodedStarRating encodedStarRating) {
        com.xmlws.ftn.soap_core.EncodedStarRating object = new com.xmlws.ftn.soap_core.EncodedStarRating();
        object.setId(encodedStarRating.getId());
        object.setName(encodedStarRating.getName());
        return object;
    }

    public List<com.xmlws.ftn.soap_core.EncodedStarRating> transformListEncodedStarRatingToXML(List<EncodedStarRating> encodedStarRating) {
        return encodedStarRating.stream()
                .map( object -> {
                    return transformEncodedRatingStarToXML(object);
                })
                .collect(Collectors.toList());
    }

}
