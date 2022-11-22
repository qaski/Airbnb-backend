package edu.uts.airbnb.Controller;
import edu.uts.airbnb.Models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:8080")
@RestController

public class YahoohController {

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object[]> getPropertyById(@PathVariable("id") String id) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "76a731a4a2msh25af040a53ceb9bp12c452jsnae8858bbf0e5");
        headers.set("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/"+id;

        Object[] results = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity, Object[].class).getBody();

        return new ResponseEntity<Object[]>(results, HttpStatus.OK);

    }

}
