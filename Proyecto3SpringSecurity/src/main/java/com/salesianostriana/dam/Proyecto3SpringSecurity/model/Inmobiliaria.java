package com.salesianostriana.dam.Proyecto3SpringSecurity.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Inmobiliaria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private String telefono;

    @Builder.Default
    @OneToMany(mappedBy = "inmobiliaria")
    private List <Vivienda> viviendas = new ArrayList();

    @OneToMany(mappedBy = "usuario")
    private List <Usuario> usuarios = new ArrayList();
    public Inmobiliaria(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
}
