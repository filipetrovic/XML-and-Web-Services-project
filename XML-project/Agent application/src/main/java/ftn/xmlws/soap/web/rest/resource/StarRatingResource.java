package ftn.xmlws.soap.web.rest.resource;

import ftn.xmlws.soap.service.AdditionalService;
import ftn.xmlws.soap.service.StarRatingService;
import ftn.xmlws.soap.web.rest.resource.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/star-ratings")
public class StarRatingResource {

    @Autowired
    private StarRatingService starRatingService;

    @GetMapping("/")
    public ResponseEntity<Response> getAllAdditionals() {
        return new ResponseEntity<>(new Response("Array list of star ratings", starRatingService.getAll()),HttpStatus.OK);
    }
}
