package ftn.xmlws.soap.config;

import com.xmlws.ftn.soap.*;
import ftn.xmlws.soap.domain.Accomodation;
import ftn.xmlws.soap.domain.PriceForPeriod;
import ftn.xmlws.soap.domain.Reservation;
import ftn.xmlws.soap.service.*;
import ftn.xmlws.soap.service.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Sync implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(Sync.class);

    @Autowired
    private AdditionalService additionalService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StarRatingService starRatingService;

    @Autowired
    private AccomodationService accomodationService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private Mapper mapper;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        logger.info("***********************************************");
        logger.info("******       Init syncing                ******");
        logger.info("***********************************************");

        SyncServicePortService syncService = new SyncServicePortService();
        SyncServicePort sync = syncService.getSyncServicePortSoap11();
        GetSyncRequest request = new GetSyncRequest();

        List<Accomodation> accomodationList = accomodationService.getAccomodations();
        List<Reservation> reservationList = reservationService.getAll();
        List<PriceForPeriod> priceForPeriodList = accomodationService.getAllPriceForPeriod();
        mapper.transformListAccomodationToXML(accomodationList).stream().forEach(dao -> request.getEncodedAccomodation().add(dao));
        mapper.transformListPricePerIntervalToXML(priceForPeriodList).stream().forEach(dao -> request.getEncodedPriceList().add(dao));
        mapper.transformEncodedRequestListToXML(reservationList).stream().forEach(dao -> request.getEncodedRequest().add(dao));

        GetSyncResponse response = sync.getSync(request);
        additionalService.sync(response.getEncodedFacility());
        categoryService.sync(response.getEncodedAccommodationType());
        starRatingService.sync(response.getEncodedStarRating());
        reservationService.saveReservation(mapper.fromCoreToReservationList(response.getEncodedReservation()));
    }
}
