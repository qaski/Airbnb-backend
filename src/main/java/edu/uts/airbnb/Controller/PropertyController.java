package edu.uts.airbnb.Controller;
import edu.uts.airbnb.Models.Property;
import edu.uts.airbnb.exceptions.ResourceNotFoundException;
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
@CrossOrigin(origins = "*")
@RestController

public class PropertyController {


    @Autowired
    PropertyRepository propertyRepository;

    @PostMapping(value="/",consumes = {"application/json"})
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

    @PutMapping("/{id}")
    public ResponseEntity<Property> editProperty(@PathVariable("id") long id, @RequestBody Property property){
        Property propertyData = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property", "id", id));

        propertyData.setTitle(property.getTitle());
        propertyData.setDescription(property.getDescription());

        Property saveProperty = propertyRepository.save(propertyData);

        return new ResponseEntity<>(saveProperty, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProperty(@PathVariable("id") long id){
        Property propertyData = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property", "id", id));

        propertyRepository.delete(propertyData);

        return HttpStatus.OK;
    }


}
