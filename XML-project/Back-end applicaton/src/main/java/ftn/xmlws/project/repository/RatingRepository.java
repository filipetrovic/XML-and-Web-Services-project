package ftn.xmlws.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	@Query("SELECT r FROM  Rating r WHERE r.approved = FALSE")
	List<Rating> getAllUnapprovedRatings();
	Rating findOneById(Long id);

}
