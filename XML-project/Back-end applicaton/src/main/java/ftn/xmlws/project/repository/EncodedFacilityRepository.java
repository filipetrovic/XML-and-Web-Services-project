package ftn.xmlws.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.EncodedFacilityOther;

@Repository
public interface EncodedFacilityRepository extends JpaRepository<EncodedFacilityOther, Long>{
	EncodedFacilityOther findOneByFacilityId(Long facilityId);
}
