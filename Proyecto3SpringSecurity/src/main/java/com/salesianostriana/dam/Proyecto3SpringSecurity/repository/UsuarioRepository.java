package com.salesianostriana.dam.Proyecto3SpringSecurity.repository;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
