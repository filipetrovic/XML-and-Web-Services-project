package ftn.xmlws.project.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.web.dto.RegistrationUserDTO;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/client/auth")
public class ClientModuleLoginController {

	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity search(@RequestBody RegistrationUserDTO registrationUserDTO) {
		
		System.out.println(registrationUserDTO  + " ovo je search dobijen DTO");

		return new ResponseEntity(HttpStatus.OK);
		
		
	}
	
}
