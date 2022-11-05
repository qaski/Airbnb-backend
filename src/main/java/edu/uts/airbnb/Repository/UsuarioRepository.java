package edu.uts.airbnb.Repository;

import edu.uts.airbnb.Models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

}
