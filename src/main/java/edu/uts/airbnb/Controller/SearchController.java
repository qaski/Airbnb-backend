package edu.uts.airbnb.Controller;

import edu.uts.airbnb.Models.Property;
import edu.uts.airbnb.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/search")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SearchController {
    @Autowired
    PropertyRepository propertyRepository;

    @GetMapping(value = "/")
    public ResponseEntity<List<Property>> searchByTitle(@RequestParam String q){
        List<Property> properties = propertyRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(q, q);

        return new ResponseEntity<>(properties, HttpStatus.OK);
    }
}