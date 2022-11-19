package edu.uts.airbnb.services;

import edu.uts.airbnb.Controller.UsuarioController;
import edu.uts.airbnb.Models.UsuarioModel;
import edu.uts.airbnb.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel>obtenerUsuarios(){
        return  (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }



}
