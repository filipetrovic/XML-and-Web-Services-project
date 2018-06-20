package ftn.xmlws.project.repository;

<<<<<<< HEAD
import java.util.List;
=======

>>>>>>> 0a65c5cdda9168b370e2ca993b5d8e110b71c1f8

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
