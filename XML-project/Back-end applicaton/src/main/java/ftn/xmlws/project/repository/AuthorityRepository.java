package ftn.xmlws.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findOneByName(String name);
	
}
