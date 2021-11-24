package com.salesianostriana.dam.Proyecto3SpringSecurity.dto.UsuarioDto;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Inmobiliaria;
import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Vivienda;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUsuarioDto {

    private String nombre, apellidos, direccion, email, telefono, avatar, password;
    private UserRole role;
    private List<Vivienda> viviendas;
    private List<Inmobiliaria> inmobiliaria;
}
