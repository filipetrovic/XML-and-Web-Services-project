package ftn.xmlws.soap.resource;

import com.xmlws.ftn.agent_soap.GetAgentResponse;
import com.xmlws.ftn.agent_soap.GetAgentRequest;
import com.xmlws.ftn.agent_soap.Reservation;
import ftn.xmlws.soap.config.ApplicationConstants;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AgentSOAPResource {

    @PayloadRoot(namespace = ApplicationConstants.ENDPOINT_AGENT, localPart = ApplicationConstants.LOCAL_PART_AGENT)
    @ResponsePayload
    public GetAgentResponse getAgentResponse(@RequestPayload GetAgentRequest request) {
        GetAgentResponse response = new GetAgentResponse();
        Reservation reser = new Reservation();
        reser.setUsername(request.getUsername());
        response.setReservation(reser);
        return response;
    }
}
