package ftn.xmlws.soap.service;

import ftn.xmlws.soap.domain.Reservation;
import ftn.xmlws.soap.repository.MessageRepository;
import ftn.xmlws.soap.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ftn.xmlws.soap.domain.Message;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void sendMessage(Long id, String content) {
        Reservation reservation = reservationRepository.findOneById(id);
        Message message = new Message();
        message.setMessage(content);
        messageRepository.save(message);
        reservation.getMessages().add(message);
        reservationRepository.save(reservation);
    }

    public Reservation confirmReservation(Long id) {
        Reservation reservation = reservationRepository.findOneById(id);
        reservation.setArrivalConfirmed(true);
        return reservationRepository.save(reservation);
    }

    public Reservation confirmReservationWithFalse(Long id) {
        Reservation reservation = reservationRepository.findOneById(id);
        reservation.setArrivalConfirmed(true);
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(Long id) {
        return reservationRepository.findOneById(id);
    }
}

