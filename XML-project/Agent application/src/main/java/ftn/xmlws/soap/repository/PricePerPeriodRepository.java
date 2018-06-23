package ftn.xmlws.soap.repository;

import ftn.xmlws.soap.domain.Accomodation;
import ftn.xmlws.soap.domain.PriceForPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PricePerPeriodRepository extends JpaRepository<PriceForPeriod, Long> {

    List<PriceForPeriod> findAllByAccomodation(Accomodation accomodation);
}
