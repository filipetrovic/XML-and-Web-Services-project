package ftn.xmlws.soap.web.rest.resource;

import com.xmlws.ftn.soap.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentResource {

    @RequestMapping("")
    public String getResponse() {
        SyncServicePortService syncService = new SyncServicePortService();
        SyncServicePort sync = syncService.getSyncServicePortSoap11();
        GetSyncRequest request = new GetSyncRequest();
        GetSyncResponse response = sync.getSync(request);
        List<EncodedFacility> lists = response.getEncodedFacility();
        return lists.toString();
    }

}
