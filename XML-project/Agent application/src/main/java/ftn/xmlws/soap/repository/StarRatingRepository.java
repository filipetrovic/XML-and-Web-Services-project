package ftn.xmlws.soap.repository;

import ftn.xmlws.soap.domain.StarRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarRatingRepository extends JpaRepository<StarRating, Long> {

    public List<StarRating> findAll();
    public StarRating findById(Long id);
}
