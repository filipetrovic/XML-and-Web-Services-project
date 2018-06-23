package ftn.xmlws.soap.web.rest.resource;

import ftn.xmlws.soap.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class StorageResource {

    @Autowired
    private StorageService storageService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void handleLogoFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        try {
            storageService.storeAccomodianImage(file, id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Fail to upload logo!");
        }
    }

    @GetMapping("/{id}/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable("filename") String filename, @PathVariable("id") Long id) {
        Resource file = storageService.getLogoFile(filename, id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(file);
    }



}
