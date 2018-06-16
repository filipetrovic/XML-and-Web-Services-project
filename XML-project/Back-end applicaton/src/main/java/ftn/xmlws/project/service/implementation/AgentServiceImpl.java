package ftn.xmlws.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Agent;
import ftn.xmlws.project.service.AgentService;
import ftn.xmlws.project.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService {
	
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public Boolean addAgent(Agent agent) {
		try {
			agentRepository.save(agent);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Agent getAgent(Long id) {
		try {
			return agentRepository.findOneById(id);
		} catch( Exception e) {
			return null;
		}
	}

	@Override
	public List<Agent> getAllAgents() {
		try {
			return agentRepository.findAll();
		} catch( Exception e) {
			return null;
		}
		
	}

}
