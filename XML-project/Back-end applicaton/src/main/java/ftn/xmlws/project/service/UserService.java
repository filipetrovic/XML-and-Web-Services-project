package ftn.xmlws.project.service;

import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.User;

@Service
public interface UserService {

	User login(User user);

	boolean registration(User user);
	
	
}
