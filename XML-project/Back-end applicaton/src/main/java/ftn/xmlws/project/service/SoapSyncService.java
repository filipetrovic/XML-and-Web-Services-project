package ftn.xmlws.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Accommodation;
import ftn.xmlws.project.beans.Reservation;

@Service
public interface SoapSyncService {

	public void syncAccommodations(List<Accommodation> accomodations);
	public void syncReservations(List<Reservation> reservations);
	
}

