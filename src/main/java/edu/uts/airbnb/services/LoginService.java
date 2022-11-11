package edu.uts.airbnb.services;
import edu.uts.airbnb.Controller.LoginController;
import edu.uts.airbnb.Models.Login;
import edu.uts.airbnb.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public ArrayList<Login>obtenerLogin(){
        return  (ArrayList<Login>) loginRepository.findAll();
    }

    public Login guardarLogin(Login login){
        return loginRepository.save(login);
    }
}
