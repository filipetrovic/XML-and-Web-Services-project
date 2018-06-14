package ftn.xmlws.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.EncodedFacility;

@Repository
public interface EncodedFacilityRepository extends JpaRepository<EncodedFacility, Long>{
	EncodedFacility findOneById(Long facilityId);
}
