package com.init.lugares.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.init.lugares.dao.LugaresDAO;
import com.init.lugares.entitys.Lugares;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class TallerRest {
	
	
	private final RestTemplate restTemplate;
	
	
	@Autowired
	public TallerRest( RestTemplate resTemplate) {
		
		this.restTemplate = resTemplate;
	}
	
	
	
		@GetMapping("/prueba")
		@ResponseStatus(HttpStatus.OK)
		public Object GetPrueba() {
			
			String url="https://wft-geo-db.p.rapidapi.com/v1/geo/adminDivisions";
			RestTemplate resTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-RapidAPI-Key", "a6cd8b693amsh24caebc3929a32bp1fbc09jsnfc86cfc458cb");
			headers.set("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");
			
			HttpEntity<String>httpEntity = new HttpEntity<>("",headers);
			Object result =  resTemplate.exchange(url,HttpMethod.GET,httpEntity,Object.class);
			return result;
		
		}
		
		@GetMapping("/sitios")
		@ResponseStatus(HttpStatus.OK)
		public Object GetSitios() {
			
			String url="https://wft-geo-db.p.rapidapi.com/v1/geo/cities/Q60/nearbyCities'";
			RestTemplate resTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-RapidAPI-Key", "210e8cbadbmshee217638b42c823p116beajsndfad54e759bb");
			headers.set("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com");
			
			HttpEntity<String>httpEntity = new HttpEntity<>("100",headers);
			Object result =  resTemplate.exchange(url,HttpMethod.GET,httpEntity,Object.class);
			return result;
		
		}
		 

}
  