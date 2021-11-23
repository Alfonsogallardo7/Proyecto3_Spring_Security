package com.salesianostriana.dam.Proyecto3SpringSecurity.repository;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Inmobiliaria;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface InmobiliariaRepository extends JpaRepository<Inmobiliaria, Long> {

    Page<Inmobiliaria> findByCliente(UserEntity cliente, Pageable pageable);
}
