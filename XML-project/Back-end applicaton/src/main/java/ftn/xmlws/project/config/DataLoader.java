package ftn.xmlws.project.config;

import java.sql.Date;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.Authority;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.User;
import ftn.xmlws.project.repository.AccommodationRepository;
import ftn.xmlws.project.repository.AuthorityRepository;
import ftn.xmlws.project.repository.EncodedFacilityRepository;
import ftn.xmlws.project.repository.UserRepository;

@Component
@SuppressWarnings("unused")
public class DataLoader implements ApplicationRunner {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private EncodedFacilityRepository encodedFacilityRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//insertIntoAccommodations();
		insertIntoUsers();
	}
	
	private void insertIntoUsers() {
		
		Authority a = new Authority();
		a.setName("REGISTERED_USER");
		Authority b = new Authority();
		b.setName("ADMIN");
		
		authorityRepository.save(a);
		authorityRepository.save(b);
		
		User u = new User();
		
		u.setFirstName("Ivan");
		u.setLastName("Jancic");
		u.setEmail("ivan@gmail.com");
		u.setUsername("ivan@gmail.com");
		
		Set<Authority> s = new HashSet<Authority>();
		s.add(a);
		
		
		
		u.setAuthorities(s);
		
		String originalInput = "123";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		
		u.setPassword(encodedString);
		
		userRepository.save(u);
		

		User u1 = new User();
		
		
		u1.setFirstName("Marko");
		u1.setLastName("Markovic");
		u1.setEmail("marko@gmail.com");
		u1.setUsername("marko@gmail.com");
		
		u1.setAuthorities(s);
		
		
		u1.setPassword(encodedString);
		
		userRepository.save(u1);
		
		User u2 = new User();
		String encodedString2 = Base64.getEncoder().encodeToString("qweasd".getBytes());
		Set<Authority> ba = new HashSet<Authority>();
		ba.add(a);
		ba.add(b);
		u2.setFirstName("Filip");
		u2.setLastName("Petrovic");
		u2.setEmail("fpetrovic@ymail.com");
		u2.setUsername("fika");
		
		u2.setAuthorities(ba);
		
		
		u2.setPassword(encodedString2);
		
		userRepository.save(u2);
		
		
	}
	
	@SuppressWarnings("deprecation")
	private void insertIntoAccommodations() {
		
//		EncodedFacility ef = new EncodedFacility();
//		ef.setName("WiFi");
//		
//		EncodedFacility ef1= new EncodedFacility();
//		ef1.setName("TV");
//		
//		EncodedFacility ef2 = new EncodedFacility();
//		ef2.setName("Restroom");
//		
//		EncodedFacility ef3 = new EncodedFacility();
//		ef3.setName("Board");
//		
//		
//		encodedFacilityRepository.save(ef);
//		encodedFacilityRepository.save(ef1);
//		encodedFacilityRepository.save(ef2);
//		encodedFacilityRepository.save(ef3);
		
		Set<EncodedFacility> additionalFacilities = new HashSet<>();
		additionalFacilities.add(encodedFacilityRepository.findOneById((long)1));
		additionalFacilities.add(encodedFacilityRepository.findOneById((long)2));
		
		// year month day
		
		Accommodation ac = new Accommodation(
				new Date(2018, 6, 6),
				new Date(2018, 8, 8),
				"Apartmani Pavlovic",
				"",
				"neki apartmani",
				3000,
				"Smederevo, Salinac",
				4,
				"appartment",
				"4 stars",
				additionalFacilities);
		
		accommodationRepository.save(ac);
		
		Set<EncodedFacility> additionalFacilities1 = new HashSet<>();
		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)3));
		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)4));
		
		
		
		Accommodation ac1 = new Accommodation(
				new Date(2018, 3, 10),
				new Date(2018, 3, 25),
				"Hotel Car",
				"",
				"veliki hotel",
				800,
				"Smederevo, Goricka 30",
				3,
				"hotel",
				"1 star",
				additionalFacilities1);
		
		accommodationRepository.save(ac1);
	}

}
