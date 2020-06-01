package com.example.demo.web;

import com.example.demo.domain.Persona;
import com.example.demo.services.PersonaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControllerREST {
    @Autowired
    private PersonaServicio personaServ; 
    
    @GetMapping("/")
    public String inicio(Model model){
        
        model.addAttribute("mensaje", "Msn");
        model.addAttribute("personas", personaServ.listarPersonas());
        log.info("Probando..");
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaServ.guardar(persona);
        return "redirect:/";
    }
    @GetMapping("/editar/{idpersona}")
    public String editar(Persona persona, Model model){
        persona = personaServ.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{idpersona}")
    public String eliminar(Persona persona){
        personaServ.eliminar(persona);
        log.info("Entre a eliminar");
        return "redirect:/";
    }
}
