package ftn.xmlws.soap.repository;

import ftn.xmlws.soap.domain.Addition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalRepository extends JpaRepository<Addition, Long> {

    public List<Addition> findAll();
    public Addition findById(Long id);
}
