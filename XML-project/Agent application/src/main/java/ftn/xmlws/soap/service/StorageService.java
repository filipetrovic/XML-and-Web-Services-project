package ftn.xmlws.soap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

@Transactional
@Service
public class StorageService {

    private static final Logger log = LoggerFactory.getLogger(StorageService.class);
    private static final String UPLOAD_LOGO_ROOT = "upload/logo/";

    @Autowired
    private AccomodationService accomodationService;


    public void storeAccomodianImage(MultipartFile file, Long accomodianId) {
        Path logoLocation = Paths.get(UPLOAD_LOGO_ROOT + accomodianId);
        initLogoPath(logoLocation);
        accomodationService.storeImage(file.getOriginalFilename().toLowerCase(), accomodianId);
        try {
            Files.deleteIfExists(logoLocation.resolve(file.getOriginalFilename().toLowerCase()));
            Files.copy(file.getInputStream(), logoLocation.resolve(file.getOriginalFilename().toLowerCase()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public FileSystemResource getLogoFile(String filename, Long id) {
        log.info(filename  + " A ID " + id);
        try {
            Path location = Paths.get(UPLOAD_LOGO_ROOT + id);
            Path file = location.resolve(filename + ".png");
            FileSystemResource resource = new FileSystemResource(file.toString());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void initLogoPath(Path path) {
        try {
            if(!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
