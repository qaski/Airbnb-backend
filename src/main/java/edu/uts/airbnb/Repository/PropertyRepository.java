package edu.uts.airbnb.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import  edu.uts.airbnb.Models.Property;


public interface PropertyRepository extends  JpaRepository<Property, Long> {
    List<Property> findByPublished(boolean published);
}
