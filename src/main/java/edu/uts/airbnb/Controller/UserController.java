package edu.uts.airbnb.Controller;

import edu.uts.airbnb.Models.Users;
import edu.uts.airbnb.Services.ServicesUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping ("/Api/Users/")
public class UserController {
    @Autowired
    private ServicesUsers servicesuser;
@PostMapping ("/guardar")
private ResponseEntity<Users> guardar (@RequestBody Users user){
    Users temporal = servicesuser.create(user);
try{
 return ResponseEntity.created(new URI("/Api/Users"+temporal.getId())).body(temporal);
}catch (Exception e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
}

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping (value = "/{id}/delete")
    private ResponseEntity<Void> Eliminar (@PathVariable Long id){
servicesuser.delete(id);
        return ResponseEntity.ok().build();
    }

}
