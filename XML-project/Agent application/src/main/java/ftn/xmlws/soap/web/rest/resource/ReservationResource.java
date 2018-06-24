package ftn.xmlws.soap.web.rest.resource;

import ftn.xmlws.soap.domain.Reservation;
import ftn.xmlws.soap.service.ReservationService;
import ftn.xmlws.soap.service.dto.MessageDTO;
import ftn.xmlws.soap.web.rest.resource.response.ListWrapper;
import ftn.xmlws.soap.web.rest.resource.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reservations")
public class ReservationResource {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    public ResponseEntity<Response> getAllAccomodation() {
        return new ResponseEntity<>(new Response("List of reservation",new ListWrapper(reservationService.getAll())),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getSingleAccomodation(@PathVariable("id") Long id) {
        Reservation retVal = reservationService.getById(id);
        if(retVal == null)
            return new ResponseEntity<>(new Response("Not found object with provided id", null),HttpStatus.BAD_REQUEST);
        return  new ResponseEntity<>(new Response("Single reservation", retVal), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> writeMessage(@PathVariable("id") Long id, @RequestBody MessageDTO messageDTO) {
        reservationService.sendMessage(id,messageDTO.getMessage());
        return new ResponseEntity<>(new Response("Message added", reservationService.getById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<Response> confirm(@PathVariable("id") Long id) {
        reservationService.confirmReservation(id);
        return new ResponseEntity<>(new Response("Reservation confirmed", reservationService.getById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}/decline")
    public ResponseEntity<Response> decline(@PathVariable("id") Long id) {
        reservationService.confirmReservationWithFalse(id);
        return new ResponseEntity<>(new Response("Reservation confirmed", reservationService.getById(id)),HttpStatus.OK);
    }
}
