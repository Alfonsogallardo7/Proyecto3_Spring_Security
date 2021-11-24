package com.salesianostriana.dam.Proyecto3SpringSecurity.dto.UsuarioDto;

import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class CreateUsuarioDto {
    private String nombre, apellidos, direccion, email, telefono, avatar, password;
    private UserRole role;
}
