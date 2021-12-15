/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto4.repository.crud;

import com.ciclo4.reto4.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author gonza
 */
public interface OrderCrudRepository extends MongoRepository <Order, Integer>{
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    @Query("{'salesMan.id': ?0}")
    List<Order> findByUserId(final int id);
    
    @Query("{'status' : ?0 , 'salesMan.id' : ?1} ")
    List<Order> findByStatusAndUserId(final String status , final int id);
    
    @Query("{'registerDay' : ?0 , 'salesMan.id' : ?1}")
    List<Order> findByDateAndUserId(final Date date , final int id);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
