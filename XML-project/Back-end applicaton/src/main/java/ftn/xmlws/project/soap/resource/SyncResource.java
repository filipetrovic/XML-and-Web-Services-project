package ftn.xmlws.project.soap.resource;

import ftn.xmlws.project.config.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import ftn.xmlws.project.soap.service.SyncService;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Endpoint for syncing resource from core app
 * @author sansajn
 */
@Endpoint
public class SyncResource {

    @Autowired
    private SyncService syncService;

	@PayloadRoot(namespace = ApplicationConstants.ENDPOINT_AGENT, localPart = ApplicationConstants.LOCAL_PART_AGENT)
    @ResponsePayload
    public com.xmlws.ftn.soap.GetSyncResponse getSyncResponse(@RequestPayload com.xmlws.ftn.soap.GetSyncRequest request) {
        com.xmlws.ftn.soap.GetSyncResponse response = new com.xmlws.ftn.soap.GetSyncResponse();
        syncService.getTypesAsXML().stream().forEach( dao -> response.getEncodedAccommodationType().add(dao));
        syncService.getFacilitysAsXML().stream().forEach( dao -> response.getEncodedFacility().add(dao));
        syncService.getStarRatingAsXML().stream().forEach( dao -> response.getEncodedStarRating().add(dao));
        return response;
    }

}
