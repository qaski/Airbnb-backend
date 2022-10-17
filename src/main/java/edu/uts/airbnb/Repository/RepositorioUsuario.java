package edu.uts.airbnb.Repository;

import edu.uts.airbnb.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
}
