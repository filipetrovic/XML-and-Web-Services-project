package ftn.xmlws.project.repository;

import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.EncodedAccommodationType;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EncodedAccommodationTypeRepository extends JpaRepository<EncodedAccommodationType, Long> {
	EncodedAccommodationType findOneByTypeId(Long typeId);
}
