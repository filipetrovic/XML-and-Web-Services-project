package ftn.xmlws.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.xmlws.project.beans.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
