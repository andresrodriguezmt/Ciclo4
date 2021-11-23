package com.ciclo4.reto1.service;

import com.ciclo4.reto1.model.User;
import com.ciclo4.reto1.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getALl(){
        return userRepository.getAll();
    }
    
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    
    public User save(User usuario){
        
        if(usuario.getId() == null){
            
            return userRepository.save(usuario);
        }
        else{
           Optional<User> varTmp = userRepository.getUser(usuario.getId());
           
           if(varTmp.isPresent()){
               return usuario;
           }
           else{
               return userRepository.save(usuario);
           } 
        }
    
    }
    
    public boolean getEmail(String email){
        
        Optional<User> verificar = userRepository.getByEmail(email);     
        
        return verificar.isPresent();
    }
    
    public User getEmailAndpassword(String email , String password){
        
        Optional<User> verificar = userRepository.getByEmailAndPassword(email, password);
        
        if(verificar.isPresent()){
            return verificar.get();
        }
        else{
            
            User usuario = new User(){};
            
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setName("NO DEFINIDO");
            
            return usuario;
        }
        
    }
}
