package ftn.xmlws.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ftn.xmlws.project.beans.Accommodation;

@Service
public interface AccommodationService {

	ArrayList<Accommodation> getAllAccommodations();
	
}
