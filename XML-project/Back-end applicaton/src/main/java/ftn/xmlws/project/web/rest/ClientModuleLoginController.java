package ftn.xmlws.project.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.xmlws.project.beans.User;
import ftn.xmlws.project.service.UserService;
import ftn.xmlws.project.web.dto.ConverterDTO;
import ftn.xmlws.project.web.dto.RegistrationUserDTO;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/client/login")
public class ClientModuleLoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity registration(@RequestBody RegistrationUserDTO registrationUserDTO) {
		
		System.out.println(registrationUserDTO  + " ovo je search dobijen DTO");

		if(userService.registration(ConverterDTO.convertToUser(registrationUserDTO)))
			return new ResponseEntity(HttpStatus.OK);
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
		
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<User> login(@RequestBody RegistrationUserDTO registrationUserDTO) {

		if(userService.login(ConverterDTO.convertToUser(registrationUserDTO)) != null)
			return new ResponseEntity<User>(userService.login(ConverterDTO.convertToUser(registrationUserDTO)), HttpStatus.OK);
		
		
		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		
		
	}
	
	
}
