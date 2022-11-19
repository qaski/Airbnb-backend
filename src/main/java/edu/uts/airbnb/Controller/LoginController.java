package edu.uts.airbnb.Controller;

import edu.uts.airbnb.Models.Login;
import edu.uts.airbnb.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SqlResultSetMapping;
import java.util.ArrayList;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping()
    public ArrayList<Login> obtenerLogin(){
        return loginService.obtenerLogin();
    }

    @PostMapping()
    public Login guardarLogin(@RequestBody Login login){
        return this.loginService.guardarLogin(login);
    }

}
