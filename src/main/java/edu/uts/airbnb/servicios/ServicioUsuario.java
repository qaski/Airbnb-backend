package edu.uts.airbnb.servicios;


import edu.uts.airbnb.Models.Usuario;

import java.util.Optional;

public interface ServicioUsuario {

    Usuario guardarUsuario(Usuario usuario);

    Optional<Usuario> obtenerUsuario(Long idUsuario);

    Usuario usuarioAModificar(Long id, Usuario  usuarioAModificar);

    boolean eliminarUsuario(Long id);

}
