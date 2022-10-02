package edu.uts.airbnb.Controller;
import edu.uts.airbnb.Models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import edu.uts.airbnb.Repository.PropertyRepository;

@RequestMapping("/api/properties")
@CrossOrigin(origins = "http://localhost:8080")
@RestController

public class PropertyController {


    @Autowired
    PropertyRepository propertyRepository;

    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        try {
            Property _property = propertyRepository
                    .save(new Property(property.getTitle(), property.getDescription(), false));
            return new ResponseEntity<>(_property, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Property> getPropertyById(@PathVariable("id") long id) {
        Optional<Property> propertyData = propertyRepository.findById(id);

        if (propertyData.isPresent()) {
            return new ResponseEntity<>(propertyData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Property>> getAll() {
        try {
            List<Property> properties = new ArrayList<Property>();

            propertyRepository.findAll().forEach(properties::add);

            if (properties.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(properties, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            propertyRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
