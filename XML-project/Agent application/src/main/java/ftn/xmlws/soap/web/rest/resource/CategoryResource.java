package ftn.xmlws.soap.web.rest.resource;

import ftn.xmlws.soap.domain.Category;
import ftn.xmlws.soap.service.CategoryService;
import ftn.xmlws.soap.web.rest.resource.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<Response> getAllAdditionals() {
        return new ResponseEntity<>(new Response("Array list of categories", categoryService.getAll()),HttpStatus.OK);
    }

}
