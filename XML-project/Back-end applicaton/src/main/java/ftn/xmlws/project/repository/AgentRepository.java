package ftn.xmlws.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.Agent;



@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

	Agent findOneById(Long id);
}
