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
    public ResponseEntity<List<Property>> searchByTitle(@RequestParam String q, @RequestParam String country){
        List<Property> properties = propertyRepository.findByTitleContainingAndCountry(q, country);

        if (country.isBlank() && q.isBlank()) {
            properties = propertyRepository.findAll();
        } else if (country.isBlank()){
            properties = propertyRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(q, q);
        } else if (q.isBlank()){
            properties = propertyRepository.findByCountryContainingIgnoreCase(country);
        }

        return new ResponseEntity<>(properties, HttpStatus.OK);
    }
}