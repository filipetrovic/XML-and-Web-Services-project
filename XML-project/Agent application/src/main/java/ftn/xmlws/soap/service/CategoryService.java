package ftn.xmlws.soap.service;

import com.xmlws.ftn.soap.EncodedAccommodationType;
import com.xmlws.ftn.soap.EncodedStarRating;
import ftn.xmlws.soap.domain.Category;
import ftn.xmlws.soap.repository.CategoryRepository;
import ftn.xmlws.soap.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return this.categoryRepository.findById(id);
    }

    public void sync(List<EncodedAccommodationType> listFromCore) {
        mapper.fromCoreToCategoryList(listFromCore)
                .stream().forEach(category -> {
            try {
                categoryRepository.save(category);
            } catch (Exception ex){ }
        });
    }
}
