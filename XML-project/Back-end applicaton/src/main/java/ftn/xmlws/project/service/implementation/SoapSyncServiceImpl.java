package ftn.xmlws.project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.Reservation;
import ftn.xmlws.project.repository.AccommodationRepository;
import ftn.xmlws.project.repository.ReservationRepository;
import ftn.xmlws.project.service.SoapSyncService;

@Service
public class SoapSyncServiceImpl implements SoapSyncService{

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public void syncAccommodations(List<Accommodation> accomodationsList) {

		try {
			for(Accommodation a: accomodationsList)
			{
				Accommodation accommodationFromDatabase = accommodationRepository.findOneByName(a.getName());
				
				
				if(accommodationFromDatabase != null)
				{
					a.setRating(accommodationFromDatabase.getRating());
					a.setAdditionalFacilities(accommodationFromDatabase.getAdditionalFacilities());
					a.setPricePerPerson(accommodationFromDatabase.getPricePerPerson());
					a.setId(accommodationFromDatabase.getId());
					
					accommodationRepository.delete(accommodationFromDatabase);
					accommodationRepository.save(a);
					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void syncReservations(List<Reservation> reservations) {
		
		try {

			for(Reservation r:reservations)
			{
				Reservation reservationFromDatabase = reservationRepository.findById(r.getId()).get();
				{
					if(reservationFromDatabase != null)
					{
						reservationFromDatabase.setMessages(r.getMessages());
						reservationFromDatabase.setArrivalConfirmed(r.isArrivalConfirmed());
						
						reservationRepository.save(reservationFromDatabase);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	

	
	
}
