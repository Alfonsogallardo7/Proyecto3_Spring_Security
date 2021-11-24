package com.salesianostriana.dam.Proyecto3SpringSecurity.dto.UsuarioDto;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDtoConverter {

    public Usuario createUsuarioDtoToUsuario (CreateUsuarioDto createUsuarioDto) {
        return new Usuario(
                createUsuarioDto.getNombre(),
                createUsuarioDto.getApellidos(),
                createUsuarioDto.getDireccion(),
                createUsuarioDto.getEmail(),
                createUsuarioDto.getTelefono(),
                createUsuarioDto.getAvatar(),
                createUsuarioDto.getPassword(),
                createUsuarioDto.getRole()
        );
    }

    public GetUsuarioDto usuarioToGetUsuarioDto (Usuario usuario) {
        return GetUsuarioDto
    }
}
