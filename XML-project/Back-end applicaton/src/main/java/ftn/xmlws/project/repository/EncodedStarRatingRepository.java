package ftn.xmlws.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.EncodedStarRating;

@Repository
public interface EncodedStarRatingRepository extends JpaRepository<EncodedStarRating, Long> {
	
}
