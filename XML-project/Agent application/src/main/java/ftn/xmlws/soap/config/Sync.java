package ftn.xmlws.soap.config;

import com.xmlws.ftn.soap.*;
import ftn.xmlws.soap.service.AdditionalService;
import ftn.xmlws.soap.service.CategoryService;
import ftn.xmlws.soap.service.StarRatingService;
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

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        logger.info("***********************************************");
        logger.info("******       Init syncing                ******");
        logger.info("***********************************************");

        SyncServicePortService syncService = new SyncServicePortService();
        SyncServicePort sync = syncService.getSyncServicePortSoap11();
        GetSyncRequest request = new GetSyncRequest();
        GetSyncResponse response = sync.getSync(request);
        additionalService.sync(response.getEncodedFacility());
        categoryService.sync(response.getEncodedAccommodationType());
        starRatingService.sync(response.getEncodedStarRating());
    }
}
