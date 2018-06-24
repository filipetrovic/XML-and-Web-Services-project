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
		insertIntoUsers();
//		insertIntoReservations();

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


		try {
			accommodationTypeRepository.save(a);
			accommodationTypeRepository.save(b);
			accommodationTypeRepository.save(c);
			accommodationTypeRepository.save(d);
			accommodationTypeRepository.save(e);
			accommodationTypeRepository.save(f);
			starRatingRepository.save(aa);
			starRatingRepository.save(bb);
			starRatingRepository.save(cc);
			starRatingRepository.save(dd);
			starRatingRepository.save(ee);
			starRatingRepository.save(ff);
 		} catch (Exception ex1) {

		}

		
		starRatingRepository.save(aa);
		starRatingRepository.save(bb);
		starRatingRepository.save(cc);
		starRatingRepository.save(dd);
		starRatingRepository.save(ee);
		starRatingRepository.save(ff);
		
//		EncodedFacility bbb = new EncodedFacility();
//		EncodedFacility ccc = new EncodedFacility();
//		EncodedFacility ddd = new EncodedFacility();
//		EncodedFacility eee = new EncodedFacility();
//		EncodedFacility fff = new EncodedFacility();
//		
//		bbb.setName("Parking");
//		ccc.setName("Spa centre");
//		ddd.setName("Gym");
//		eee.setName("Swimming pool");
//		fff.setName("Sauna");
//		
//		encodedFacilityRepository.save(bbb);
//		encodedFacilityRepository.save(ccc);
//		encodedFacilityRepository.save(ddd);
//		encodedFacilityRepository.save(eee);
//		encodedFacilityRepository.save(fff);
		
		

	}
	
	private void insertIntoAgents() {
		
		Agent a = new Agent("Ivan","Jancic","Lukijana Musickog 75, Smederevo", "AppJancic");
		Agent b = new Agent("Nemanja","Mudri","Djurdja Brankovica 4, Novi Sad", "Auto skola Volan");
		Agent c = new Agent("Filip","Petrovic","Dimitrija Dimovica 20, Zrenjanin", "Krilca");

		try {
			agentRepository.save(a);
			agentRepository.save(b);
			agentRepository.save(c);
		} catch (Exception e) {

		}
	}
	
	private void insertIntoRatings() {
		
		Rating r = new Rating("Jako dobar smestaj.", 5, (long)1, (long)1, false);
		Rating r1 = new Rating("Ocajan smestaj, sve smrdi.", 1, (long)2, (long)2, true);
		Rating r2 = new Rating("Smestaj ima dvoriste za mog psa Mikicu. Fini domacini.", 4, (long)2, (long)2, false);
		try {
			ratingRepository.save(r);
			ratingRepository.save(r1);
			ratingRepository.save(r2);
		} catch (Exception e) {

		}
	}
	
	private void insertIntoUsers() {
		
		Authority a = new Authority();
		a.setName("REGISTERED_USER");
		Authority b = new Authority();
		b.setName("ADMIN");
		

		
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

		User u1 = new User();
		
		
		u1.setFirstName("Marko");
		u1.setLastName("Markovic");
		u1.setEmail("marko@gmail.com");
		u1.setUsername("marko@gmail.com");
		
		u1.setAuthorities(s);
		
		
		u1.setPassword(encodedString);
		
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
		try {
			authorityRepository.save(a);
			authorityRepository.save(b);

			userRepository.save(u);
			userRepository.save(u1);
			userRepository.save(u2);
		} catch(Exception e) {

		}
		
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
		
		try {
			encodedFacilityRepository.save(ef);
			encodedFacilityRepository.save(ef1);
			encodedFacilityRepository.save(ef2);
			encodedFacilityRepository.save(ef3);
		} catch(Exception ex) {

		}
	}
	
	private void insertIntoReservations() {

//		Reservation r = reservationRepository.findById((long)22).get();
		

		Reservation r = new Reservation();

		
		r.setPriceOfReservation(5000);
		r.setUser(userRepository.findOneByUsername("ivan@gmail.com").get());
		r.setCheckInDate(Date.valueOf("2018-06-27"));
		r.setCheckOutDate(Date.valueOf("2018-06-30"));
		r.setAccommodation(accommodationRepository.findById((long)1).get());
		
		Set<Message> messages = new HashSet<Message>();

		Reservation r1 = new Reservation();
		

		r1.setPriceOfReservation(10000);
		r1.setUser(userRepository.findOneByUsername("ivan@gmail.com").get());
		r1.setCheckInDate(new Date(200000));
		r1.setCheckOutDate(new Date(2000002));
		r1.setAccommodation(accommodationRepository.findById((long)2).get());

		try {
//			reservationRepository.save(r);
			reservationRepository.save(r1);
		} catch (Exception ex) {

		}

		for(Message m:messageRepository.findAll())
			if(m.getReservation().getId() == (long)22)
				messages.add(m);

//		r.setMessages(messages);
//		try {
////			reservationRepository.save(r);
//		} catch (Exception e) {
//
//		}

		Message m = new Message();
		m.setMessage("Can I come at 21pm?");
		m.setUserSender(true);
		m.setReservation(r);
		messages.add(m);
		
		Message m1 = new Message();
		m1.setMessage("Yes you may!");
		m1.setUserSender(false);
		m1.setReservation(r);
		messages.add(m1);		
		
		r.setMessages(messages);
		reservationRepository.save(r);
		
		
		
		
		
		
		
		Reservation r1 = new Reservation();
		
		r1.setPriceOfReservation(10000);
		r1.setUser(userRepository.findOneByUsername("ivan@gmail.com").get());
		r1.setCheckInDate(Date.valueOf("2018-06-27"));
		r1.setCheckOutDate(Date.valueOf("2018-06-28"));
		r1.setAccommodation(accommodationRepository.findById((long)2).get());
		
		Set<Message> messages2 = new HashSet<Message>();
		
		Message m3 = new Message();
		m3.setMessage("Hello do you accept dogs?");
		m3.setUserSender(true);
		m3.setReservation(r1);
		messages2.add(m3);
		
		Message m4 = new Message();
		m4.setMessage("Yes we love big fluffy dogs!");
		m4.setUserSender(false);
		m4.setReservation(r1);
		messages2.add(m4);	
		
		r1.setMessages(messages2);
		
		reservationRepository.save(r1);
		
		
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
		try {
			messageRepository.save(m);
			messageRepository.save(m1);
		}catch (Exception e) {

		}

		
		messageRepository.save(m);
		messageRepository.save(m1);
	}
	
	private void insertIntoAccommodations() {
		
		Set<EncodedFacility> additionalFacilities = new HashSet<>();
		additionalFacilities.add(encodedFacilityRepository.findOneById((long)1));
		additionalFacilities.add(encodedFacilityRepository.findOneById((long)2));
			
		Accommodation ac = new Accommodation(
				java.sql.Date.valueOf("2018-06-24"),
				java.sql.Date.valueOf("2018-08-24"),
				"Apartmani Pekic",
				"",
				"neki novi apartmani",
				1750,
				3,
				"Smederevo, Carina",
				5,
				accommodationTypeRepository.findById((long)1).get(),
				starRatingRepository.findOneById((long)5),
				null, additionalFacilities);
		
		
		
		Set<EncodedFacility> additionalFacilities1 = new HashSet<>();
		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)3));
		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)4));
		
		// yy mm dd
		Accommodation ac1 = new Accommodation(
				Date.valueOf("2018-06-26"),
				Date.valueOf("2018-06-29"),
				"Hotel Viking",
				"",
				"veliki hotel vikinga",
				4000,
				5, "Smederevo, Kneza Milosa 35",
				4,
				accommodationTypeRepository.findById((long)3).get(),
				starRatingRepository.findOneById((long)2),
				null, additionalFacilities1);
		
		ac.setReservations(new HashSet<Reservation>());
		ac1.setReservations(new HashSet<Reservation>());
		
		accommodationRepository.save(ac);
		accommodationRepository.save(ac1);

	}
	
//	@SuppressWarnings("deprecation")
//	private void insertIntoAccommodations() {
//
//		Set<EncodedFacility> additionalFacilities = new HashSet<>();
//		additionalFacilities.add(encodedFacilityRepository.findOneById((long) 1));
//		additionalFacilities.add(encodedFacilityRepository.findOneById((long) 2));
//
//		additionalFacilities.add(encodedFacilityRepository.findOneById((long)1));
//		additionalFacilities.add(encodedFacilityRepository.findOneById((long)2));
//
//		SimpleDateFormat sdf = new SimpleDateFormat("23/06/2018");
//		java.util.Date parsed = null;
//
//		SimpleDateFormat sdfEnd = new SimpleDateFormat("23/08/2018");
//		java.util.Date parsedEnd = null;
//
//		try {
//			parsed = sdf.parse("23/06/2018");
//			parsedEnd = sdfEnd.parse("23/08/2018");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		Date startDate = new Date(parsed.getTime());
//		Date endDate = new Date(parsedEnd.getTime());
//
//
//		Accommodation ac = new Accommodation(
//				startDate,
//				endDate,
//				"Apartmani Pekic",
//				"",
//				"neki novi apartmani",
//				1750,
//				3,
//				"Smederevo, Carina",
//				5,
//				"appartment",
//				"5 stars",
//				additionalFacilities);
//
//
//
//		Set<EncodedFacility> additionalFacilities1 = new HashSet<>();
//		additionalFacilities1.add(encodedFacilityRepository.findOneById((long) 3));
//		additionalFacilities1.add(encodedFacilityRepository.findOneById((long) 4));
//
//
//				accommodationTypeRepository.findById((long)1).get(),
//				starRatingRepository.findOneById((long)5),
//				null, additionalFacilities);
//
//
//
//		Set<EncodedFacility> additionalFacilities1 = new HashSet<>();
//		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)3));
//		additionalFacilities1.add(encodedFacilityRepository.findOneById((long)4));
//
//
//		SimpleDateFormat sdfStat1 = new SimpleDateFormat("24/06/2018");
//		java.util.Date sdfParsed1 = null;
//
//		SimpleDateFormat sdfEnd1 = new SimpleDateFormat("28/06/2018");
//		java.util.Date parsedEnd1 = null;
//
//		try {
//			sdfParsed1 = sdfStat1.parse("24/06/2018");
//			parsedEnd1 = sdfEnd1.parse("28/06/2018");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		Date startDate1 = new Date(sdfParsed1.getTime());
//		Date endDate1 = new Date(parsedEnd1.getTime());
//
//		Accommodation ac1 = new Accommodation(
//				startDate1,
//				endDate1,
//				"Hotel Viking",
//				"",
//				"veliki hotel vikinga",
//				4000,
//				5, "Smederevo, Kneza Milosa 35",
//				4,
//				"hotel",
//				"2 star",
//				additionalFacilities1);
//		try {
//			accommodationRepository.save(ac);
//			accommodationRepository.save(ac1);
//		} catch (Exception ex) {
//
//		}
//				accommodationTypeRepository.findById((long)3).get(),
//				starRatingRepository.findOneById((long)2),
//				null, additionalFacilities1);
//
//		ac.setReservations(new HashSet<Reservation>());
//		ac1.setReservations(new HashSet<Reservation>());
//
//		accommodationRepository.save(ac);
//		accommodationRepository.save(ac1);
//
//		System.out.println("Successfully inserted into DB: ");
//		System.out.println(accommodationRepository.findAll());
//	}

}
