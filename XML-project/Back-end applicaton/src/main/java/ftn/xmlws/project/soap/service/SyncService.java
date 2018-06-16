package ftn.xmlws.project.soap.service;


import ftn.xmlws.project.service.EncodedEntitiesService;
import ftn.xmlws.project.soap.service.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<com.xmlws.ftn.soap_core.EncodedAccommodationType> getTypesAsXML() {
        return entityMapper.transformListEncodedAccommodationTypesEntityToXML(encodedEntitiesService.getAllAccommodationTypes());
    }

    public List<com.xmlws.ftn.soap_core.EncodedFacility> getFacilitysAsXML() {
        return entityMapper.transformListEncodedFacilityToXML(encodedEntitiesService.getAllFacilities());
    }

    public List<com.xmlws.ftn.soap_core.EncodedStarRating> getStarRatingAsXML() {
        return entityMapper.transformListEncodedStarRatingToXML(encodedEntitiesService.getAllStarRatings());
    }

}
