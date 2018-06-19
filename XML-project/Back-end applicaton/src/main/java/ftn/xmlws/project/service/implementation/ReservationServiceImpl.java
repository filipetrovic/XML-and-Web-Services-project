package ftn.xmlws.project.service.implementation;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Reservation;
import ftn.xmlws.project.beans.User;
import ftn.xmlws.project.repository.AccommodationRepository;
import ftn.xmlws.project.repository.ReservationRepository;
import ftn.xmlws.project.repository.UserRepository;
import ftn.xmlws.project.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Override
	public boolean makeReservation(Reservation r, String username, Long accommodationId) {
		
		try {
			
			User u = userRepository.findOneByUsername(username).get();
			
			r.setAccommodation(accommodationRepository.findById(accommodationId).get());
			r.setUser(u);
			
			reservationRepository.save(r);
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Set<Reservation> getReservations(String username) {
		
		try {
			
			return userRepository.findOneByUsername(username).get().getReservations();
			
		} catch(Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
	}



}
