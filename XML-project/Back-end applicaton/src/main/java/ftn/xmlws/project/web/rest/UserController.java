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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.beans.User;
import ftn.xmlws.project.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return new ResponseEntity<List<User>>(repository.findAll(),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("An error occurred while reading Users from database");
			return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(@RequestParam("username") String username ) {
		try {
			return new ResponseEntity<User>(repository.findOneByUsername(username).get(), HttpStatus.OK); 
		} catch (Exception e) {
			System.out.println("An error occured while reading User from database");
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/banUser")
	public ResponseEntity<Boolean> banUser(@RequestBody User user ) {
		try {
			
			user.setBanned(true);
			repository.save(user);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK); 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occured while banning User from database");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/unbanUser")
	public ResponseEntity<Boolean> unbanUser(@RequestBody User user ) {
		try {
			
			user.setBanned(false);
			repository.saveAndFlush(user);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK); 
		} catch (Exception e) {
			System.out.println("An error occured while unbanning User from database");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<Boolean> deleteUser(@RequestBody User user ) {
		try {
			
			user.setDeleted(true);
			repository.saveAndFlush(user);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK); 
		} catch (Exception e) {
			System.out.println("An error occured while deleting User from database");
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
	}
	

}
