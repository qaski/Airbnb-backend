package edu.uts.airbnb.Repository;
import edu.uts.airbnb.Models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login ,Long> {
}
