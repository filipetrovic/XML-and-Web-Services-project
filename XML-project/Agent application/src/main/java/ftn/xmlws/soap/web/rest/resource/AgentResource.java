package ftn.xmlws.soap.web.rest.resource;

import com.xmlws.ftn.soap.*;
import ftn.xmlws.soap.service.AdditionalService;
import ftn.xmlws.soap.service.CategoryService;
import ftn.xmlws.soap.service.StarRatingService;
import ftn.xmlws.soap.service.dto.LoginDTO;
import ftn.xmlws.soap.web.rest.resource.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentResource {

    @Value("${INSTANCE_AGENT_USERNAME}")
    private String username;

    @Value("${INSTANCE_AGENT_PASSWORD}")
    private String password;

    @Value("${INSTANCE_URL}")
    private String url;

    @Autowired
    private AdditionalService additionalService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StarRatingService starRatingService;

    private static final Logger logger = LoggerFactory.getLogger(AgentResource.class);

    @GetMapping("")
    public String getResponse() {
        SyncServicePortService syncService = new SyncServicePortService();
        SyncServicePort sync = syncService.getSyncServicePortSoap11();
        GetSyncRequest request = new GetSyncRequest();
        GetSyncResponse response = sync.getSync(request);
        List<EncodedFacility> lists = response.getEncodedFacility();
        return lists.toString();
    }

    @PostMapping("")
    public ResponseEntity<Response> login(@RequestBody LoginDTO loginDTO) {
        if(loginDTO.getUsername().equals(username) && loginDTO.getPassword().equals(password)) {
            SyncServicePortService syncService = new SyncServicePortService();
            SyncServicePort sync = syncService.getSyncServicePortSoap11();
            GetSyncRequest request = new GetSyncRequest();
            request.setAgentId(username);
            GetSyncResponse response = sync.getSync(request);
            logger.info("SYNC");
            additionalService.sync(response.getEncodedFacility());
            categoryService.sync(response.getEncodedAccommodationType());
            starRatingService.sync(response.getEncodedStarRating());
            return new ResponseEntity<>(new Response("Approved", url), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Wrong Credentials", null),HttpStatus.BAD_REQUEST);
    }

}
