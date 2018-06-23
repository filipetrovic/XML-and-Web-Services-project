package ftn.xmlws.project.web.rest;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.beans.Authority;
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
	
	@GetMapping("/getAllUsersThatAreNotAdmins")
	public ResponseEntity<List<User>> getAllUsersThatAreNotAdmins() {
		try {
			List<User> users = repository.findAll();
			List<User> toRemove = new ArrayList<User>();
			for(User u: users){
				for(Authority a : u.getAuthorities()) {
				    if(a.getName().equals("ADMIN")){
				        toRemove.add(u);
				        break;
				    }
				}
			}
			System.out.println(toRemove.size());
			users.removeAll(toRemove);
			System.out.println(users.size());
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			
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
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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
