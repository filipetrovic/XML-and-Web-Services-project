package ftn.xmlws.soap.repository;

import ftn.xmlws.soap.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findAll();
    public Category findById(Long id);
}
