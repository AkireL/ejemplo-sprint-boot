/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.diao;

import com.example.demo.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Erika Basurto
 */
public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
