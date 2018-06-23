package ftn.xmlws.soap.web.rest.resource;

import ftn.xmlws.soap.domain.Accomodation;
import ftn.xmlws.soap.domain.PriceForPeriod;
import ftn.xmlws.soap.service.AccomodationService;
import ftn.xmlws.soap.service.StorageService;
import ftn.xmlws.soap.service.dto.AccomodationDTO;
import ftn.xmlws.soap.service.dto.PriceDTO;
import ftn.xmlws.soap.web.rest.resource.response.ListWrapper;
import ftn.xmlws.soap.web.rest.resource.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accomodations")
public class AccomodationResource {

    private static final Logger logger = LoggerFactory.getLogger(AccomodationResource.class);

    @Autowired
    private AccomodationService accomodationService;

    @PostMapping("")
    public ResponseEntity<Response> createAccomodation(@RequestBody AccomodationDTO accomodationDTO) {
        Accomodation retVal = accomodationService.createAccomodation(accomodationDTO);
        if(retVal == null)
            return new ResponseEntity<>(new Response("Adding new accomodation has failed", null),HttpStatus.BAD_REQUEST);
        return  new ResponseEntity<>(new Response("Image id", retVal.getId()), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Response> getAllAccomodation() {
        return new ResponseEntity<>(new Response("List of accomodations",new ListWrapper(accomodationService.getAccomodations())),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getSingleAccomodation(@PathVariable("id") Long id) {
        Accomodation retVal = accomodationService.getAccomodation(id);
        if(retVal == null)
            return new ResponseEntity<>(new Response("Not found object with provided id", null),HttpStatus.BAD_REQUEST);
        return  new ResponseEntity<>(new Response("Single accomodation", retVal), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteAccomodation(@PathVariable("id") Long id) {
        try {
            accomodationService.deleteAccomodation(id);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response("Not found object with provided id", null),HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(new Response("Deleted object", null), HttpStatus.OK);
    }

    @PutMapping("/{id}/set-price")
    public ResponseEntity<Response> setPriceForInterval(@PathVariable("id") Long id, @RequestBody PriceDTO priceDTO) {
        return new ResponseEntity<>(new Response("Added price for period", accomodationService.setPriceForInterval(id,priceDTO)),HttpStatus.OK);
    }

    @GetMapping("/{id}/set-price")
    public ResponseEntity<Response> setPriceForInterval(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new Response("Added price for period", accomodationService.getPriceForAccomodian(id)),HttpStatus.OK);
    }

}
