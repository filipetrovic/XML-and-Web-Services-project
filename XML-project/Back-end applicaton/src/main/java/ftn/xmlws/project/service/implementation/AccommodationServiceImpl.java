package ftn.xmlws.project.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.EncodedFacility;
import ftn.xmlws.project.beans.Reservation;
import ftn.xmlws.project.repository.AccommodationRepository;
import ftn.xmlws.project.repository.ReservationRepository;
import ftn.xmlws.project.service.AccommodationService;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public ArrayList<Accommodation> getAllAccommodations() {

		return accommodationRepository.findAll();
	}

	@Override
	public ArrayList<Accommodation> getAccommodationsBasedOnSearchParams(Accommodation accommodation) {
		
		ArrayList<Accommodation> matchedAccommodations = new ArrayList<Accommodation>();
		
		for(Accommodation a:accommodationRepository.findAll())
		{
			
			System.out.println(a.getId());
			// if the check in date is before the first available date
			if(accommodation.getStartDateAvailable().before(a.getStartDateAvailable()))
			{
				System.out.println(a.getName() + " continue on start date");
				System.out.println(a.getStartDateAvailable() + " searched: " + accommodation.getStartDateAvailable());
				continue;
			}
			
			// if the check out date is after the last available date
			if(accommodation.getEndDateAvailable().after(a.getEndDateAvailable()))
			{
				System.out.println(a.getName() + " continue on end date");
				System.out.println(a.getEndDateAvailable() + " searched: " + accommodation.getEndDateAvailable());
				continue;
			}
			
			// if the input address is not contained in search (smederevo, musicka 75), search is smederevo
			if(!a.getInputAddress().contains(accommodation.getInputAddress()))
			{
				System.out.println(a.getName() + " continue on input address");
				System.out.println(a.getInputAddress() + " searched: " + accommodation.getInputAddress());
				continue;
			}
			
			if(accommodation.getNumberOfPeople()>a.getNumberOfPeople())
			{
				System.out.println(a.getName() + " continue on getNumberOfPeople");
				System.out.println(a.getNumberOfPeople() + " searched: " + accommodation.getNumberOfPeople());
				continue;
			}
			
			if(!accommodation.getTypeOfAccommodation().equals(""))
				if(!accommodation.getTypeOfAccommodation().equals(a.getTypeOfAccommodation()))
				{
					System.out.println(a.getName() + " continue on getTypeOfAccommodation");
					System.out.println(a.getTypeOfAccommodation() + " searched: " + accommodation.getTypeOfAccommodation());
					continue;
				}
			
			if(!accommodation.getCategory().equals(""))
				if(!accommodation.getCategory().equals(a.getCategory()))
				{
					System.out.println(a.getName() + " continue on getCategory");
					System.out.println(a.getCategory() + " searched: " + accommodation.getCategory());
					continue;
				}
			
			for(EncodedFacility ef:accommodation.getAdditionalFacilities())
			{
				if(!a.getAdditionalFacilities().contains(ef))
				{
					System.out.println(a.getName() + " continue on getAdditionalFacilities");
					System.out.println(a.getAdditionalFacilities() + " searched: " + accommodation.getAdditionalFacilities());
					continue;
				}
			}		
			
			System.out.println("Successfully found : " + a);
			
			boolean thereIsAReservation = false;
			
			for(Reservation r:reservationRepository.findAll())
			{
				if(r.getAccommodation().equals(a))
				{
//					System.out.println(r.getAccommodation().getId());
//					System.out.println("should be equal to acomodation searched: ");
//					System.out.println(a);
//					
//					System.out.println(accommodation.getStartDateAvailable()  + " should be after " + r.getCheckInDate());
//					System.out.println(accommodation.getEndDateAvailable()  + " should be before " + r.getCheckOutDate());
//					
//					System.out.println("First check");
//					System.out.println((accommodation.getStartDateAvailable().after(r.getCheckInDate()) && 
//							accommodation.getEndDateAvailable().before(r.getCheckInDate())));
//					
//					System.out.println("Second check");
//					System.out.println((accommodation.getStartDateAvailable().after(r.getCheckOutDate()) && 
//					accommodation.getEndDateAvailable().before(r.getCheckOutDate())));
					
					
					
					/*
					 * algorithm used for reservations checking
					 * 
					Date min, max;   // assume these are set to something
					Date d;          // the date in question

					return d.after(min) && d.before(max);
					*/
					

					
					LocalDate searchStartDate = accommodation.getStartDateAvailable().toLocalDate();
					LocalDate reservationCheckInDate = accommodation.getStartDateAvailable().toLocalDate();
					System.out.println("Local date comparison: ");
					System.out.println(searchStartDate.equals(reservationCheckInDate));
					
					LocalDate searchEndDate = accommodation.getEndDateAvailable().toLocalDate();
					LocalDate reservationCheckOutDate = accommodation.getEndDateAvailable().toLocalDate();
					System.out.println("Local date comparison: ");
					System.out.println(searchEndDate.equals(reservationCheckOutDate));
					
	
					if(searchStartDate.equals(reservationCheckInDate) || searchEndDate.equals(reservationCheckOutDate))
					{
						thereIsAReservation = true;
						System.out.println("There is a reservation on the same date!");
						continue;
					}
					
					
					if(!(
							(accommodation.getStartDateAvailable().after(r.getCheckInDate()) && 
								accommodation.getEndDateAvailable().before(r.getCheckInDate()))	&& 
									(accommodation.getStartDateAvailable().after(r.getCheckOutDate()) && 
											accommodation.getEndDateAvailable().before(r.getCheckOutDate()))
						))
					{
						System.out.println("This reservation does not interfere with searched dates!");
					}
					else
					{
						System.out.println("Reservation found for following dates!");
						thereIsAReservation = true;
					}
				}
			}
			
			System.out.println("There is a reservation?" + thereIsAReservation);
			
			if(!thereIsAReservation)
				matchedAccommodations.add(a);
				
		}
		
		return matchedAccommodations;
	}

}
