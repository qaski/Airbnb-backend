package edu.uts.airbnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class api {

    private final RestTemplate restTemplate;

    @Autowired
    public api (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public Object test() {
        String url = "https://api.crimeometer.com/v1/incidents/raw-data?lat=33.729610&lon=84.409736&distance=100m&datetime_ini=2020-12-01T15:53:00.000Z&datetime_end=2022-01-20T15:00:00.000Z&page=1";
        Object forObject = restTemplate.getForObject(url, Object.class);
        return  forObject;

    }
}
