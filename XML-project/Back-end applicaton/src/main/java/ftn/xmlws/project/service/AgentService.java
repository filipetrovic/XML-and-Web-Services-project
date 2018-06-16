package ftn.xmlws.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Agent;

@Service
public interface AgentService {
	
	List<Agent> getAllAgents();
	Agent getAgent(Long id);
	Boolean addAgent(Agent agent);
	

}
