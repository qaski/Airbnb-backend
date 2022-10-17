package edu.uts.airbnb.Controller;

import edu.uts.airbnb.Models.Usuario;
import edu.uts.airbnb.servicios.ServicioUsuario;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    @PostMapping
    public ResponseEntity guardarUsuario(@RequestBody Usuario usuario){
    return new ResponseEntity(servicioUsuario.guardarUsuario(usuario), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity obtenerUsuario(@PathVariable("id") Long idUsuario) {
        return new ResponseEntity(servicioUsuario.obtenerUsuario(idUsuario), HttpStatus.OK);}

    @PutMapping("/{id}")
    public ResponseEntity modificarUsuario (@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario){
        return new ResponseEntity(servicioUsuario.usuarioAModificar(idUsuario, usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario (@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario){
        boolean respuesta = servicioUsuario.eliminarUsuario(idUsuario);
        if (respuesta == true){
        return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    }