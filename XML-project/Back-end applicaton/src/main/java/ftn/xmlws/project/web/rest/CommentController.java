package ftn.xmlws.project.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.beans.Rating;
import ftn.xmlws.project.repository.RatingRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/comments")
public class CommentController {
	
	@Autowired
	private RatingRepository repository;
	
	@GetMapping("/getUnapprovedComments")
	public ResponseEntity<List<Rating>> getUnapprovedComments(){
		try {
			return new ResponseEntity<List<Rating>>(repository.getAllUnapprovedRatings(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Rating>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/approveComment")
	public ResponseEntity<Boolean> approveComment(@RequestBody Rating r) {
		try {
			r.setApproved(true);
			repository.save(r);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error occured while approving comment");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/deleteComment")
	public ResponseEntity<Boolean> deleteComment(@RequestBody Rating r){
		try {
			repository.delete(r);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error occured while deleting comment");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
	}
 
}
