package ftn.xmlws.project.service.implementation;

import java.util.Base64;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Authority;
import ftn.xmlws.project.beans.User;
import ftn.xmlws.project.repository.AuthorityRepository;
import ftn.xmlws.project.repository.UserRepository;
import ftn.xmlws.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public User login(User user) {
		
		try {
			User u = userRepository.findOneByUsername(user.getUsername()).get();
			System.out.println(u.getAuthorities().size());
			
			if(u != null)
			{
				byte[] decodedBytes = Base64.getDecoder().decode(u.getPassword());
				String decodedString = new String(decodedBytes);
				
				if(decodedString.equals(user.getPassword()))
				{
					System.out.println("Passwords match! " + decodedString + " == " + user.getPassword());
					user.setEmail(u.getEmail());
					user.setFirstName(u.getFirstName());
					user.setLastName(u.getLastName());
					user.setPassword("nice try mr hacker!");
					user.setAuthorities(u.getAuthorities());
					return user;
				}
			}
			
			return null;
			
		} catch(NoSuchElementException exc)
		{
			return null;
		}
		
	}

	@Override
	public boolean registration(User user) {
		
		try {
			@SuppressWarnings("unused")
			User u = userRepository.findOneByUsername(user.getUsername()).get();
			
			return false;
		}
		catch(NoSuchElementException exc)
		{
			User u = new User();
			
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			u.setEmail(user.getEmail());
			u.setUsername(user.getUsername());
		
			Set<Authority> s = new HashSet<Authority>();
			s.add(authorityRepository.findOneByName("REGISTERED_USER"));
			
			u.setAuthorities(s);
			
			String originalInput = user.getPassword();
			String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
			
			u.setPassword(encodedString);
			
			System.out.println("Saving user: " + u);
			userRepository.save(u);
			
			return true;
		}
		
		
	}

}
