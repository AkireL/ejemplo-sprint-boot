package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="persona")
// Data from loombok
// this add setters and getters
public class Persona implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpersona;
    
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    
}
