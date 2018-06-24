package ftn.xmlws.project.soap.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.Reservation;
import ftn.xmlws.project.config.ApplicationConstants;
import ftn.xmlws.project.service.SoapSyncService;
import ftn.xmlws.project.soap.service.SyncService;

/**
 * Endpoint for syncing resource from core app
 * @author sansajn
 */
@Endpoint
public class SyncResource {

    @Autowired
    private SyncService syncService;
    
    @Autowired
    private SoapSyncService soapSyncServiceCoreBackend;

	@PayloadRoot(namespace = ApplicationConstants.ENDPOINT_AGENT, localPart = ApplicationConstants.LOCAL_PART_AGENT)
    @ResponsePayload
    public generated.soap.com.xmlws.ftn.soap.GetSyncResponse getSyncResponse(@RequestPayload generated.soap.com.xmlws.ftn.soap.GetSyncRequest request) {
        generated.soap.com.xmlws.ftn.soap.GetSyncResponse response = new generated.soap.com.xmlws.ftn.soap.GetSyncResponse();
        syncService.getTypesAsXML().stream().forEach( dao -> response.getEncodedAccommodationType().add(dao));
        syncService.getFacilitysAsXML().stream().forEach( dao -> response.getEncodedFacility().add(dao));
        syncService.getStarRatingAsXML().stream().forEach( dao -> response.getEncodedStarRating().add(dao));
        syncService.getReservationAsXML().stream().forEach( dao -> response.getEncodedReservation().add(dao));

        List<Accommodation> accommodationList = syncService.getAccomodationFromXml(request.getEncodedAccomodation());
        
        soapSyncServiceCoreBackend.syncAccommodations(accommodationList);
        
        List<ftn.xmlws.project.beans.PricePerInterval> pricePerIntervalsList = syncService.getPricePerIntervalFromXml(request.getEncodedPriceList());
        // dobijem id od smestaja, string od kog datuma je ta cena do kog datuma je ta cena, i string cene
        
        
        List<Reservation> reservationsList = syncService.getHelperDTOFromXML(request.getEncodedRequest());
        
        soapSyncServiceCoreBackend.syncReservations(reservationsList);
        
        // dalje staviti gde treba da se upise u bazu
        
        
        
        return response;
    }

}
