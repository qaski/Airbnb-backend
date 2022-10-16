package edu.uts.airbnb.Services;

import edu.uts.airbnb.Models.Users;
import edu.uts.airbnb.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesUsers {
    @Autowired
    private UsersRepository userRepository;

    
    public Users create (Users user ){
        return userRepository.save(user);
    }

    public List<Users>getUsers(){
        return userRepository.findAll();
    }

    public void delete (Long id){
        userRepository.deleteById(id);
    }

    public Optional<Users> findById (Long id){
        return userRepository.findById(id);

    }
}
