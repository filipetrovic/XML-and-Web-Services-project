package ftn.xmlws.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
