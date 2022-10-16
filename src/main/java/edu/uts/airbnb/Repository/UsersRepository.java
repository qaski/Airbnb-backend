package edu.uts.airbnb.Repository;

import edu.uts.airbnb.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    /*List<Users> findByPublished(boolean published);*/
}

