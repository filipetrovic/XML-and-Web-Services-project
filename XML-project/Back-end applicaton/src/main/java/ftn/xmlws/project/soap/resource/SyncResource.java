package ftn.xmlws.project.soap.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import ftn.xmlws.project.soap.service.SyncService;

/**
 * Endpoint for syncing resource from core app
 * @author sansajn
 */
@Endpoint
public class SyncResource {

    @Autowired
    private SyncService syncService;
//
//	@PayloadRoot(namespace = ApplicationConstants.ENDPOINT_AGENT, localPart = ApplicationConstants.LOCAL_PART_AGENT)
//    @ResponsePayload
//    public GetSyncResponse getSyncResponse(@RequestPayload GetSyncRequest request) {
//        GetSyncResponse response = new GetSyncResponse();
//        syncService.getTypesAsXML().stream().forEach( dao -> response.getEncodedAccommodationType().add(dao));
//        syncService.getFacilitysAsXML().stream().forEach( dao -> response.getEncodedFacility().add(dao));
//        syncService.getStarRatingAsXML().stream().forEach( dao -> response.getEncodedStarRating().add(dao));
//        return response;
//    }

}
