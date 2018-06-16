package ftn.xmlws.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.xmlws.project.beans.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOneByUsername(String username);
}
