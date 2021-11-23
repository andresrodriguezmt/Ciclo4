
package com.ciclo4.reto1.repository.crud;

import com.ciclo4.reto1.model.User;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface UserCrudRepository extends CrudRepository<User, Object >{
    
    
    Optional<User> findByEmail(String email);
    
    
    Optional<User> findByEmailAndPassword(String email, String password);
}
