package ftn.xmlws.soap.service;

import ftn.xmlws.soap.domain.Accomodation;
import ftn.xmlws.soap.domain.PriceForPeriod;
import ftn.xmlws.soap.repository.AccomodationRepository;
import ftn.xmlws.soap.repository.PricePerPeriodRepository;
import ftn.xmlws.soap.service.dto.AccomodationDTO;
import ftn.xmlws.soap.service.dto.PriceDTO;
import ftn.xmlws.soap.service.mapper.MapperDTO;
import ftn.xmlws.soap.service.util.DateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationService {

    @Autowired
    private MapperDTO mapperDTO;

    @Autowired
    private DateParser dateParser;

    @Autowired
    private AccomodationRepository accomodationRepository;

    @Autowired
    private PricePerPeriodRepository pricePerPeriodRepository;

    @Value("${INSTANCE_URL}")
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
        accomodation.setImage(path + "/" + url);
        accomodationRepository.save(accomodation);
    }

    public PriceForPeriod setPriceForInterval(Long id, PriceDTO priceDTO) {
        Accomodation accomodation = accomodationRepository.findOne(id);
        PriceForPeriod priceForPeriod = new PriceForPeriod();
        priceForPeriod.setAccomodation(accomodation);
        priceForPeriod.setPrice(priceDTO.getPrice());
        priceForPeriod.setStartDate(dateParser.parseDate(priceDTO.getStartFrom()));
        priceForPeriod.setEndDate(dateParser.parseDate(priceDTO.getEnd()));
        return pricePerPeriodRepository.save(priceForPeriod);
    }

    public List<PriceForPeriod> getPriceForAccomodian(Long id) {
        Accomodation accomodation = accomodationRepository.findOne(id);
        return pricePerPeriodRepository.findAllByAccomodation(accomodation);
    }

    public List<PriceForPeriod> getAllPriceForPeriod() {
        return pricePerPeriodRepository.findAll();
    }

}
