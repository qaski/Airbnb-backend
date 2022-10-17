package edu.uts.airbnb.servicios;

import edu.uts.airbnb.Models.Usuario;
import edu.uts.airbnb.Repository.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicioUsuarioImpl  implements ServicioUsuario{

    private final RepositorioUsuario repositorioUsuario;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuario(Long idUsuario) {
        return Optional.ofNullable(repositorioUsuario.findById(idUsuario).orElseThrow(() -> {
            throw new RuntimeException();
        }));
    }

    @Override
    public Usuario usuarioAModificar(Long id, Usuario usuarioAModificar) {
        Usuario usuarioBuscado = repositorioUsuario.findById(id).get();
        usuarioBuscado.setDireccion(usuarioAModificar.getDireccion());
        usuarioBuscado.setTelefono(usuarioAModificar.getTelefono());
        return repositorioUsuario.save(usuarioBuscado);
    }

    @Override
    public boolean eliminarUsuario(Long id) {

        try {
                repositorioUsuario.deleteById(id);
                return true;
        }catch (Exception e){
                return false;
        }
    }
}
