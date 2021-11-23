
package com.ciclo4.reto1.controller;

import com.ciclo4.reto1.model.User;
import com.ciclo4.reto1.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getUsuarios(){
        return userService.getALl();
    }
    /**
     * 
            @GetMapping("/{id}")
            public Optional<User> getUsuario(@PathVariable("id") int id){
                return userService.getUser(id);
            }
    */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User usuario){
        return userService.save(usuario);
    }
    
    @GetMapping("/{email}")
    public boolean getEmail(@PathVariable("email") String email){
        return userService.getEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User getEmailAndPassword(@PathVariable("email") String email , @PathVariable("password") String password){
        return userService.getEmailAndpassword(email, password);
    }
}
