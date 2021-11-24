package com.salesianostriana.dam.Proyecto3SpringSecurity.repository;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Usuario;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findByAutenticado (UserEntity cliente, Pageable pageable);
}
