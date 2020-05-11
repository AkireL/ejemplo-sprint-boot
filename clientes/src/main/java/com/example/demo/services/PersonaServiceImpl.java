/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.diao.PersonaDao;
import com.example.demo.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Erika Basurto
 */
@Service // Clase identificada como servicio
public class PersonaServiceImpl implements PersonaServicio{
    
    @Autowired
    private PersonaDao personaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() 
    {
        return (List)personaDao.findAll();    
    }

    @Override
    @Transactional // como va a modificar tiene que abrir una transación
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
        
    }

    @Override
    @Transactional(readOnly=true)
    public Persona encontrarPersona(Persona persona) {
       return personaDao.findById(persona.getIdpersona()).orElse(null);
    }
    
}
