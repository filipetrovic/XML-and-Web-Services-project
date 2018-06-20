package ftn.xmlws.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {


	
}
