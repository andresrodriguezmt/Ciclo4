package com.ciclo4.reto4.repository.crud;

import com.ciclo4.reto4.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gonza
 */
public interface UserCrudRepository extends MongoRepository<User,Integer>{
    
    Optional<User> findByEmail(String email);
    //List<User> findBybirthDay(Date date);
    Optional<User> findByEmailAndPassword(String email, String password);
   // Optional<User> findByNameOrEmail(String name, String email);
    Optional<User> findTopByOrderByIdDesc();
}
