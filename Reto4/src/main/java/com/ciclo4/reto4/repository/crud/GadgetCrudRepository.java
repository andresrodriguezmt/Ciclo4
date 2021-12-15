/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto4.repository.crud;

import com.ciclo4.reto4.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gonza
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer>{
    
}
