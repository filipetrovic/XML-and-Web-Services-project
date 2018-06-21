package ftn.xmlws.adminmodule.web.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ftn.xmlws.adminmodule.beans.Authority;
import ftn.xmlws.adminmodule.beans.RegistrationUserDTO;
import ftn.xmlws.adminmodule.beans.User;



@RestController
@CrossOrigin
public class UserController {
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody RegistrationUserDTO user){
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		try {
			User response = restTemplate.postForObject("http://localhost:8080/api/client/login", user,  User.class);
			for (Authority a : response.getAuthorities()) {
				if ( a.getName().equals("ADMIN")) {
					return new ResponseEntity<User>(response, HttpStatus.OK);
				}
			}
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/addAccommodationType");
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
			
	}

	
	@GetMapping("/getAllUsersThatAreNotAdmins") 
	public ResponseEntity<List<User>> getAllUsers() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/users/getAllUsersThatAreNotAdmins", User[].class);
			User[] types = responseEntity.getBody();
			
			return new ResponseEntity<List<User>>(Arrays.asList(types),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/getAllUsers");
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(@RequestParam("username") String username ) {
		RestTemplate restTemplate = new RestTemplate();
		
		URI targetUrl= UriComponentsBuilder.fromUriString("http://localhost:8080")  
		    .path("/api/users/getUser")                           
		    .queryParam("username", username)                               
		    .build()                                                 
		    .encode()                                                
		    .toUri();                                                
		
		try {
			User f = restTemplate.getForObject(targetUrl, User.class);
			return new ResponseEntity<User>(f, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occurred while trying getUser from back-end database");
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/banUser")
	public ResponseEntity<Boolean> banUser(@RequestBody User user ) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> entity = new HttpEntity<>(user);
		
		System.out.println(user.toString());
		
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/users/banUser", 
            														HttpMethod.PUT, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("An error occurred while trying to access back-end-module/banUser");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	@PutMapping("/unbanUser")
	public ResponseEntity<Boolean> unbanUser(@RequestBody User user ) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> entity = new HttpEntity<>(user);
		
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/users/unbanUser", 
            														HttpMethod.PUT, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	System.out.println("An error occurred while trying to access back-end-module/unbanUser");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<Boolean> deleteUser(@RequestBody User user ) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> entity = new HttpEntity<>(user);
		
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/users/deleteUser", 
            														HttpMethod.DELETE, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("An error occurred while trying to access back-end-module/deleteUser");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
	}
}
