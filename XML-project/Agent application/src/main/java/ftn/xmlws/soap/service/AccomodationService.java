package ftn.xmlws.soap.service;

import ftn.xmlws.soap.domain.Accomodation;
import ftn.xmlws.soap.repository.AccomodationRepository;
import ftn.xmlws.soap.service.dto.AccomodationDTO;
import ftn.xmlws.soap.service.mapper.MapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationService {

    @Autowired
    private MapperDTO mapperDTO;

    @Autowired
    private AccomodationRepository accomodationRepository;

    @Value("${agent}")
    private String path;

    public Accomodation createAccomodation(AccomodationDTO rawAccomodation) {
        Accomodation accomodation = mapperDTO.fromDTOtoAccomodation(rawAccomodation);
        return accomodationRepository.save(accomodation);
    }

    public Accomodation getAccomodation(Long id) {
        return accomodationRepository.findOne(id);
    }

    public List<Accomodation> getAccomodations() {
        return accomodationRepository.findAll();
    }

    public void deleteAccomodation(Long id) {
        try {
            accomodationRepository.delete(id);
        } catch (Exception e) {

        }
    }

    public Accomodation editAccomodation(AccomodationDTO rawAccomodationDTO, Long id) {
        Accomodation accomodation = accomodationRepository.findOne(id);
        accomodation.setName(rawAccomodationDTO.getName());
        return  accomodation;
    }

    public void storeImage(String url, Long id) {
        Accomodation accomodation = accomodationRepository.findOne(id);
        accomodation.setImage(path + url);
        accomodationRepository.save(accomodation);
    }
}
