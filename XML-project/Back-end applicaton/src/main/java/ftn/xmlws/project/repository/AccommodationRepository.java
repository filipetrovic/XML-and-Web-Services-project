package ftn.xmlws.project.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.xmlws.project.beans.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

	ArrayList<Accommodation> findAll();
	Accommodation findOneByName(String name);
	
}
