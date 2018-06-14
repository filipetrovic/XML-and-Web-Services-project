package ftn.xmlws.soap.resource;

import com.xmlws.ftn.soap.GetAgentResponse;
import com.xmlws.ftn.soap.GetAgentRequest;
import ftn.xmlws.soap.config.ApplicationConstants;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AgentResource {

    @PayloadRoot(namespace = ApplicationConstants.ENDPOINT_AGENT, localPart = ApplicationConstants.LOCAL_PART_AGENT)
    @ResponsePayload
    public GetAgentResponse getAgentResponse(@RequestPayload GetAgentRequest request) {
        GetAgentResponse response = new GetAgentResponse();
        return response;
    }
}
