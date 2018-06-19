package ftn.xmlws.project.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Reservation;

@Service
public interface ReservationService {

	boolean makeReservation(Reservation r, String username, Long accommodationId);

	Set<Reservation> getReservations(String username);

	boolean cancelReservation(Long reservationId, String username);

}
