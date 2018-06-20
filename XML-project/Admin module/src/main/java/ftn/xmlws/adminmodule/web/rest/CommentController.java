package ftn.xmlws.adminmodule.web.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ftn.xmlws.adminmodule.beans.Rating;

@RestController
@CrossOrigin
public class CommentController {
	@GetMapping("/getUnapprovedComments")
	public ResponseEntity<List<Rating>> getUnapprovedComments() {
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<Rating[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/comments/getUnapprovedComments", Rating[].class);
			Rating[] types = responseEntity.getBody();
			
			return new ResponseEntity<List<Rating>>(Arrays.asList(types),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("An error occurred while trying to access back-end-module/getUnapprovedComments");
			return new ResponseEntity<List<Rating>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/approveComment")
	public ResponseEntity<Boolean> approveComment(@RequestBody Rating comment) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Rating> entity = new HttpEntity<>(comment);
		
		System.out.println(comment.toString());
		
        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/comments/approveComment", 
            														HttpMethod.PUT, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("An error occurred while trying to access back-end-module/approveComment");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	@DeleteMapping("/deleteComment")
	public ResponseEntity<Boolean> deleteComment(@RequestBody Rating comment) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Rating> entity = new HttpEntity<>(comment);
		
        try {
        	
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://localhost:8080/api/comments/deleteComment", 
            														HttpMethod.DELETE, entity, Boolean.class);
            return responseEntity;
        } catch (Exception e) {
        	System.out.println("An error occurred while trying to access back-end-module/deleteAccommodationType");
        	return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        }
	}
	
	
}
