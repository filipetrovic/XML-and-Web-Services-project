package ftn.xmlws.adminmodule.web.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ftn.xmlws.adminmodule.beans.Agent;

@RestController
@CrossOrigin
public class AgentController {
	
	@GetMapping("/getAgent")
	public ResponseEntity<Agent> getAgent(@RequestParam("id") Long id){
		RestTemplate restTemplate = new RestTemplate();
		
		URI targetUrl= UriComponentsBuilder.fromUriString("http://localhost:8080")  
		    .path("/api/agent/getAgent")                           
		    .queryParam("id", id)                               
		    .build()                                                 
		    .encode()                                                
		    .toUri();                                                
		
		try {
			Agent f = restTemplate.getForObject(targetUrl, Agent.class);
			return new ResponseEntity<Agent>(f, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occurred while trying getAgent from back-end database");
			return new ResponseEntity<Agent>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllAgents")
	public ResponseEntity<List<Agent>> getAllAgents(){
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<Agent[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/agent/getAllAgents", Agent[].class);
			Agent[] types = responseEntity.getBody();
			
			return new ResponseEntity<List<Agent>>(Arrays.asList(types),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/getAllAgents");
			return new ResponseEntity<List<Agent>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addAgent")
	public ResponseEntity<Boolean> addAgent(@RequestParam("name") String name,
											@RequestParam("surname") String surname,
											@RequestParam("address") String address,
											@RequestParam("bussinessNumber") String bussinessNumber){
		
		if(address.equals("")) {
			System.out.println("Address can't be empty");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
		if(bussinessNumber.equals("")) {
			System.out.println("Bussiness number can't be empty");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
		
		Agent agent = new Agent(name,surname,address,bussinessNumber);
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			Boolean response = restTemplate.postForObject("http://localhost:8080/api/agent/addAgent", agent, Boolean.class);
			
			return new ResponseEntity<Boolean>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/addAgent");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
	}
	
}
