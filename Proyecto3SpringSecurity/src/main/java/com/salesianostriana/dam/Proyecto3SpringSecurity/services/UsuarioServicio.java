package com.salesianostriana.dam.Proyecto3SpringSecurity.services;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Usuario;
import com.salesianostriana.dam.Proyecto3SpringSecurity.repository.UsuarioRepository;
import com.salesianostriana.dam.Proyecto3SpringSecurity.services.base.BaseService;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServicio extends BaseService<Usuario, Long , UsuarioRepository> {

    public Page<Usuario> findAllByAutenticado (UserEntity user, Pageable pageable) {
        return repositorio.findByAutenticado(user, pageable);
    }
}
