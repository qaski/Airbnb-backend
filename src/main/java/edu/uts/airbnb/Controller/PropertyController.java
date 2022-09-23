package edu.uts.airbnb.Controller;
import edu.uts.airbnb.Models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import edu.uts.airbnb.Repository.PropertyRepository;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
@RestController

public class PropertyController {


    @Autowired
    PropertyRepository propertyRepository;

    @PostMapping(value="/properties",consumes = {"application/json"})
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        try {
            Property _property = propertyRepository
                    .save(new Property(property.getTitle(), property.getDescription(), false));
            return new ResponseEntity<>(_property, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
