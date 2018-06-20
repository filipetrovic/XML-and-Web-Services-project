package ftn.xmlws.soap.service;

import com.xmlws.ftn.soap.EncodedFacility;
import com.xmlws.ftn.soap.EncodedStarRating;
import ftn.xmlws.soap.domain.StarRating;
import ftn.xmlws.soap.repository.StarRatingRepository;
import ftn.xmlws.soap.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarRatingService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private StarRatingRepository starRatingRepository;

    public List<StarRating> getAll() {
        return starRatingRepository.findAll();
    }

    public StarRating findById(Long id) {
        return starRatingRepository.findById(id);
    }

    public void sync(List<EncodedStarRating> listFromCore) {
        mapper.fromCoreToStarRatingList(listFromCore)
                .stream().forEach(starRating -> {
            try {
                starRatingRepository.save(starRating);
            } catch (Exception ex){ }
        });
    }
}
