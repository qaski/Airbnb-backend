package edu.uts.airbnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;

@RestController
public class api {

    private final RestTemplate restTemplate;

    @Autowired
    public api (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public Object test() {
        String url = "https://wft-geo-db.p.rapidapi.com/v1/geo/adminDivisions";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "d567afd758msh137dd6bf7812f8ap17616ajsn26a8cdf25c85");
        headers.set("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");
        headers.set("content-type", "multipart/form-data; boundary=---011000010111000001101001");
        HttpEntity <String> httpEntity = new HttpEntity<>("", headers);
        Object forObject = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class);
        return  forObject;
    }
}
