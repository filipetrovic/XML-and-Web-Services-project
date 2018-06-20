package ftn.xmlws.soap.service;

import com.xmlws.ftn.soap.EncodedFacility;
import ftn.xmlws.soap.domain.Addition;
import ftn.xmlws.soap.repository.AdditionalRepository;
import ftn.xmlws.soap.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalService {

    @Autowired
    private AdditionalRepository additionalRepository;

    @Autowired
    private Mapper mapper;

    public List<Addition> getAll() {
        return this.additionalRepository.findAll();
    }

    public Addition getById(Long id) { return this.additionalRepository.findById(id); }

    public void sync(List<com.xmlws.ftn.soap.EncodedFacility> listFromCore) {
        mapper.fromCoreToAdditionList(listFromCore)
                .stream().forEach(addition -> {
                    try {
                        additionalRepository.save(addition);
                    } catch (Exception ex){ }
                });
    }
}
