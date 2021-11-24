package com.salesianostriana.dam.Proyecto3SpringSecurity.model;

import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserRole;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;

    private String apellidos;

    private String direccion;

    private String email;

    private String telefono;

    @Lob
    private String avatar;

    private String password;

    private UserRole role;

    @Builder.Default
    @OneToMany(mappedBy = "interesado")
    private List<Interesa> interesa = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "inmobiliaria_id")
    private List<Inmobiliaria> inmobiliarias = new ArrayList<>();

    public Usuario(String nombre, String apellidos, String direccion, String email, String telefono, String avatar, String password, UserRole role) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.avatar = avatar;
        this.password = password;
        this.role = role;
    }
}
