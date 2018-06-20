package ftn.xmlws.soap.service.mapper;

import com.xmlws.ftn.soap.EncodedFacility;
import ftn.xmlws.soap.domain.Addition;
import ftn.xmlws.soap.domain.Category;
import ftn.xmlws.soap.domain.StarRating;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Mapper {

    public List<Addition> fromCoreToAdditionList(List<com.xmlws.ftn.soap.EncodedFacility> fromCoreList) {
        return fromCoreList
                .stream()
                .map( object -> {
                    return fromCoreToAddition(object);
                })
                .collect(Collectors.toList());
    }

    public Addition fromCoreToAddition(com.xmlws.ftn.soap.EncodedFacility fromCore) {
        Addition object = new Addition(fromCore.getName());
        object.setId(fromCore.getId());
        return object;
    }

    public Category fromCoreToCategory(com.xmlws.ftn.soap.EncodedAccommodationType fromCore) {
        Category object = new Category(fromCore.getName());
        object.setId(fromCore.getId());
        return object;
    }

    public List<Category> fromCoreToCategoryList(List<com.xmlws.ftn.soap.EncodedAccommodationType> fromCoreList) {
        return fromCoreList
                .stream()
                .map( object -> {
                    return fromCoreToCategory(object);
                })
                .collect(Collectors.toList());
    }

    public StarRating fromCoreToStarRating(com.xmlws.ftn.soap.EncodedStarRating fromCore) {
        StarRating object = new StarRating(fromCore.getName());
        object.setId(fromCore.getId());
        return object;
    }

    public List<StarRating> fromCoreToStarRatingList(List<com.xmlws.ftn.soap.EncodedStarRating> fromCoreList) {
        return fromCoreList
                .stream()
                .map( object -> {
                    return fromCoreToStarRating(object);
                })
                .collect(Collectors.toList());
    }


}
