package com.init.lugares.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.init.lugares.dao.LugaresDAO;
import com.init.lugares.entitys.Lugares;
import java.util.List;
import java.util.Optional;


@RestController //clase como servicio 

@RequestMapping("Lugares") //En que url se expondra todos los metodos de este servicio
public class LugaresREST {
	
	    @Autowired 
		private LugaresDAO lugaresDAO;
	   
		@GetMapping
	 	public ResponseEntity<List<Lugares>> getLugares(){
			List<Lugares> lugares = lugaresDAO.findAll();
			return ResponseEntity.ok(lugares);
	 	}
		@RequestMapping(value= "{lugaresId}")
		public ResponseEntity<Lugares> getLugaresById(@PathVariable("lugaresId") Long lugaresId){
			Optional<Lugares> optionalLugares  = lugaresDAO.findById(lugaresId);
			 if (optionalLugares.isPresent()) {
				 return ResponseEntity.ok(optionalLugares.get());
			 }else {
				 return ResponseEntity.noContent().build();
			 }
	 	}
	
	
		  @PutMapping
		  public ResponseEntity<Lugares> updateLugares(@RequestBody Lugares lugares){
			  Optional<Lugares> optionalLugares = lugaresDAO.findById(lugares.getId());
			  if (optionalLugares.isPresent()) {
				  Lugares updateLugares = optionalLugares.get();
				  updateLugares.setNombre(lugares.getNombre());
				  lugaresDAO.save(updateLugares);
				  return ResponseEntity.ok(updateLugares);
				
			}else {
				return ResponseEntity.notFound().build();
			}
			  
		  }

}
  