package ftn.xmlws.soap.service.mapper;

import ftn.xmlws.soap.domain.Accomodation;
import ftn.xmlws.soap.domain.Addition;
import ftn.xmlws.soap.service.AdditionalService;
import ftn.xmlws.soap.service.CategoryService;
import ftn.xmlws.soap.service.StarRatingService;
import ftn.xmlws.soap.service.dto.AccomodationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@Service
public class MapperDTO {

    @Autowired
    private AdditionalService additionalService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StarRatingService starRatingService;

    public Accomodation fromDTOtoAccomodation(AccomodationDTO accomodationDTO) {
        Accomodation object = new Accomodation();
        object.setName(accomodationDTO.getName());
        object.setDescription(accomodationDTO.getDescription());
        object.setAddress(accomodationDTO.getAddress());
        object.setCity(accomodationDTO.getCity());
        object.setAgentName(accomodationDTO.getAgentName());
        object.setNumber(accomodationDTO.getNumber());

        SimpleDateFormat sdfStat1 = new SimpleDateFormat(accomodationDTO.getStartFrom());
		java.util.Date sdfParsed1 = null;
		SimpleDateFormat sdfEnd1 = new SimpleDateFormat(accomodationDTO.getEnd());
		java.util.Date parsedEnd1 = null;

		try {
			sdfParsed1 = sdfStat1.parse(accomodationDTO.getStartFrom());
			parsedEnd1 = sdfEnd1.parse(accomodationDTO.getEnd());
		} catch (ParseException e) {
			e.printStackTrace();
		}

        Date startDate1 = new Date(sdfParsed1.getTime());
		Date endDate1 = new Date(parsedEnd1.getTime());

        object.setStartDateAvailable(startDate1);
        object.setEndDateAvailable(endDate1);
        object.setCategory(categoryService.findById(Long.valueOf(String.valueOf(accomodationDTO.getCategory()))));
        object.setStarRating(starRatingService.findById(Long.valueOf(String.valueOf(accomodationDTO.getStarRating()))));
        object.setAdditions(accomodationDTO.getAdditions()
                .stream()
                .map( additional -> {
                    return additionalService.getById(Long.valueOf(additional));
                })
                .collect(Collectors.toList()));
        return  object;
    }

}
