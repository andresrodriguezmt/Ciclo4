package com.ciclo4.reto1.repository;

import com.ciclo4.reto1.model.User;
import com.ciclo4.reto1.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    
    public User save(User usuario){
        return userCrudRepository.save(usuario);           
    }
    
    public Optional<User> getByEmail(String email){
        return userCrudRepository.findByEmail(email);
    }
    
    public Optional<User> getByEmailAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
