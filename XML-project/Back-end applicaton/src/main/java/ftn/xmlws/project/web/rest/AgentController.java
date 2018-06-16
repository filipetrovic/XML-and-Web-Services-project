package ftn.xmlws.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.beans.Agent;
import ftn.xmlws.project.service.AgentService;

@RestController
@CrossOrigin
@RequestMapping("/api/agent")
public class AgentController {
	
	@Autowired 
	private AgentService service;
	
	@GetMapping("/getAllAgents")
	public ResponseEntity<List<Agent>> getAllAgents(){
		return new ResponseEntity<List<Agent>> (service.getAllAgents(), HttpStatus.OK);
	}
	
	@GetMapping("/getAgent")
	public ResponseEntity<Agent> getAgent(@RequestParam("id") Long id){
		return new ResponseEntity<Agent>(service.getAgent(id), HttpStatus.OK);
	}
	
	@PostMapping("/addAgent")
	public ResponseEntity<Boolean> addAgent(@RequestBody Agent agent){
		try {
			
			return new ResponseEntity<Boolean>(service.addAgent(agent), HttpStatus.CREATED);
		} catch (Exception e) {
			return  new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
}
