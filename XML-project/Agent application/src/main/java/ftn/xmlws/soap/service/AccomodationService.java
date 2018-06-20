package ftn.xmlws.soap.service;

import ftn.xmlws.soap.domain.Accomodation;
import ftn.xmlws.soap.repository.AccomodationRepository;
import ftn.xmlws.soap.service.dto.AccomodationDTO;
import ftn.xmlws.soap.service.mapper.MapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccomodationService {

    @Autowired
    private MapperDTO mapperDTO;

    @Autowired
    private AccomodationRepository accomodationRepository;

    public Accomodation createAccomodation(AccomodationDTO rawAccomodation) {
        Accomodation accomodation = mapperDTO.fromDTOtoAccomodation(rawAccomodation);
        return accomodationRepository.save(accomodation);
    }
}
