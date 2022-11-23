package edu.uts.airbnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Api_controller {

    private final RestTemplate restTemplate;
    @Autowired
    public Api_controller (RestTemplate  restTemplate){
        this.restTemplate = restTemplate;

    }


    @GetMapping("/api")
    public Object api() {
        String url = "https://wft-geo-db.p.rapidapi.com/v1/geo/adminDivisions";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "d567afd758msh137dd6bf7812f8ap17616ajsn26a8cdf25c85");
        headers.set("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");
        headers.set("content-type", "multipart/form-data; boundary=---011000010111000001101001");
        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
        Object forObject = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class);
        return forObject;
    }

}
