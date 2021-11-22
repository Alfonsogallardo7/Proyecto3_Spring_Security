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


}
