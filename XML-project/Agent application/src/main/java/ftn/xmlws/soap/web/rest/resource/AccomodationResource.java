package ftn.xmlws.soap.web.rest.resource;

import ftn.xmlws.soap.domain.Accomodation;
import ftn.xmlws.soap.service.AccomodationService;
import ftn.xmlws.soap.service.dto.AccomodationDTO;
import ftn.xmlws.soap.web.rest.resource.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accomodations")
public class AccomodationResource {

    @Autowired
    private AccomodationService accomodationService;

    @PostMapping("/")
    public ResponseEntity<Response> createAccomodation(@RequestBody AccomodationDTO accomodationDTO) {
        Accomodation retVal = accomodationService.createAccomodation(accomodationDTO);
        if(retVal == null)
            return new ResponseEntity<>(new Response("Adding new accomodation has failed", null),HttpStatus.BAD_REQUEST);
        return  new ResponseEntity<>(new Response("Image id", retVal.getId()), HttpStatus.CREATED);
    }

//    @GetMapping("/")
//    public ResponseEntity<Response> getAllAccomodation() {
//
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Response> getSingleAccomodation() {
//
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Response> editSingleAccomodation() {
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Response> deleteAccomodation() {
//
//    }
}
