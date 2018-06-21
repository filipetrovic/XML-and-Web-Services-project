package ftn.xmlws.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.xmlws.project.beans.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
