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
import ftn.xmlws.project.beans.Agent;
import ftn.xmlws.project.beans.Authority;
import ftn.xmlws.project.beans.EncodedAccommodationType;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.EncodedStarRating;
import ftn.xmlws.project.beans.Message;
import ftn.xmlws.project.beans.Rating;
import ftn.xmlws.project.beans.Reservation;
import ftn.xmlws.project.beans.User;
import ftn.xmlws.project.repository.AccommodationRepository;
import ftn.xmlws.project.repository.AgentRepository;
import ftn.xmlws.project.repository.AuthorityRepository;
import ftn.xmlws.project.repository.EncodedAccommodationTypeRepository;
import ftn.xmlws.project.repository.EncodedFacilityRepository;
import ftn.xmlws.project.repository.EncodedStarRatingRepository;
import ftn.xmlws.project.repository.MessageRepository;
import ftn.xmlws.project.repository.RatingRepository;
import ftn.xmlws.project.repository.ReservationRepository;
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
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private EncodedStarRatingRepository starRatingRepository;
	
	@Autowired
	private EncodedAccommodationTypeRepository accommodationTypeRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		insertIntoEncodedFacility();
//		insertIntoEncodedEntities();
//		insertIntoAgents();
//		insertIntoAccommodations();
//		insertIntoMessages();
//		insertIntoReservations();
//		insertIntoRatings();
//		insertIntoUsers();
		
	}
	
	private void insertIntoEncodedEntities() {
		EncodedAccommodationType a = new EncodedAccommodationType();
		EncodedAccommodationType b = new EncodedAccommodationType();
		EncodedAccommodationType c = new EncodedAccommodationType();
		EncodedAccommodationType d = new EncodedAccommodationType();
		EncodedAccommodationType e = new EncodedAccommodationType();
		EncodedAccommodationType f = new EncodedAccommodationType();
		a.setName("Hotel");
		b.setName("Hostel");
		c.setName("Apartments");
		d.setName("Guest house");
		e.setName("Homestay");
		f.setName("Bed and breakfast");
		
		accommodationTypeRepository.save(a);
		accommodationTypeRepository.save(b);
		accommodationTypeRepository.save(c);
		accommodationTypeRepository.save(d);
		accommodationTypeRepository.save(e);
		accommodationTypeRepository.save(f);
		
		EncodedStarRating aa = new EncodedStarRating();
		EncodedStarRating bb = new EncodedStarRating();
		EncodedStarRating cc = new EncodedStarRating();
		EncodedStarRating dd = new EncodedStarRating();
		EncodedStarRating ee = new EncodedStarRating();
		EncodedStarRating ff = new EncodedStarRating();
		aa.setName("Unrated");
		bb.setName("1 star");
		cc.setName("2 stars");
		dd.setName("3 stars");
		ee.setName("4 stars");
		ff.setName("5 stars");
		
		starRatingRepository.save(aa);
		starRatingRepository.save(bb);
		starRatingRepository.save(cc);
		starRatingRepository.save(dd);
		starRatingRepository.save(ee);
		starRatingRepository.save(ff);
	}
	
	private void insertIntoAgents() {
		
		Agent a = new Agent("Ivan","Jancic","Lukijana Musickog 75, Smederevo", "AppJancic");
		Agent b = new Agent("Nemanja","Mudri","Djurdja Brankovica 4, Novi Sad", "Auto skola Volan");
		Agent c = new Agent("Filip","Petrovic","Dimitrija Dimovica 20, Zrenjanin", "Krilca");
		
		agentRepository.save(a);
		agentRepository.save(b);
		agentRepository.save(c);
	}
	
	private void insertIntoRatings() {
		
		Rating r = new Rating("Jako dobar smestaj.", 5, (long)1, (long)1, false);
		Rating r1 = new Rating("Ocajan smestaj, sve smrdi.", 1, (long)2, (long)2, true);
		Rating r2 = new Rating("Smestaj ima dvoriste za mog psa Mikicu. Fini domacini.", 4, (long)2, (long)2, false);
		
		ratingRepository.save(r);
		ratingRepository.save(r1);
		ratingRepository.save(r2);
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
	
	private void insertIntoEncodedFacility() {
		
		EncodedFacility ef = new EncodedFacility();
		ef.setName("WiFi");
		
		EncodedFacility ef1= new EncodedFacility();
		ef1.setName("TV");
		
		EncodedFacility ef2 = new EncodedFacility();
		ef2.setName("Restroom");
		
		EncodedFacility ef3 = new EncodedFacility();
		ef3.setName("Board");
		
		
		encodedFacilityRepository.save(ef);
		encodedFacilityRepository.save(ef1);
		encodedFacilityRepository.save(ef2);
		encodedFacilityRepository.save(ef3);
	}
	
	@SuppressWarnings("unchecked")
	private void insertIntoReservations() {
	
		Reservation r = reservationRepository.findById((long)22).get();
		
		
//		r.setPriceOfReservation(5000);
//		r.setUser(userRepository.findOneByUsername("ivan@gmail.com").get());
//		r.setCheckInDate(new Date(110000));
//		r.setCheckOutDate(new Date(11000011));
//		r.setAccommodation(accommodationRepository.findById((long)1).get());
		
		Set<Message> messages = new HashSet<Message>();
		
		for(Message m:messageRepository.findAll())
			if(m.getReservation().getId() == (long)22)
				messages.add(m);
				
		r.setMessages(messages);
		reservationRepository.save(r);
//		r.setMessages(messages);
//		
//		reservationRepository.save(r);
//		
//		Reservation r1 = new Reservation();
//		
//		r1.setPriceOfReservation(10000);
//		r1.setUser(userRepository.findOneByUsername("ivan@gmail.com").get());
//		r1.setCheckInDate(new Date(200000));
//		r1.setCheckOutDate(new Date(2000002));
//		r1.setAccommodation(accommodationRepository.findById((long)2).get());
//		
//		Set<Message> messages1 = new HashSet<Message>();
//		
//		for(Message m:messageRepository.findAll())
//			if(m.getReservation().getId() == 2)
//				messages1.add(m);
//				
//		
//		r.setMessages(messages1);
//		
//		reservationRepository.save(r1);
		
		
	}
	
	private void insertIntoMessages() {
		
		Message m = new Message();
		m.setMessage("Can I come at 21pm?");
		m.setReservation(reservationRepository.findById((long)1).get());
		m.setUserSender(true);
		
		Message m1 = new Message();
		m1.setMessage("Yes you may!");
		m1.setReservation(reservationRepository.findById((long)1).get());
		m1.setUserSender(false);
		
		messageRepository.save(m);
		messageRepository.save(m1);
	}
	
	@SuppressWarnings("deprecation")
	private void insertIntoAccommodations() {
		
		Set<EncodedFacility> additionalFacilities = new HashSet<>();
		additionalFacilities.add(encodedFacilityRepository.findOneById((long)1));
		additionalFacilities.add(encodedFacilityRepository.findOneById((long)2));
		
		// year month day
		
		Accommodation ac = new Accommodation(
				new Date(2018, 6, 18),
				new Date(2018, 8, 18),
				"Apartmani Pekic",
				"",
				"neki novi apartmani",
				1750,
				3,
				"Smederevo, Carina",
				5,
				"appartment",
				"5 stars",
				null, additionalFacilities);
		
		
		
		Set<EncodedFacility> additionalFacilities1 = new HashSet<>();
		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)3));
		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)4));
		
		
		
		Accommodation ac1 = new Accommodation(
				new Date(2018, 6, 14),
				new Date(2018, 8, 14),
				"Hotel Viking",
				"",
				"veliki hotel vikinga",
				4000,
				5, "Smederevo, Kneza Milosa 35",
				4,
				"hotel",
				"2 star",
				null, additionalFacilities1);
		
		accommodationRepository.save(ac);
		accommodationRepository.save(ac1);
	}

}
