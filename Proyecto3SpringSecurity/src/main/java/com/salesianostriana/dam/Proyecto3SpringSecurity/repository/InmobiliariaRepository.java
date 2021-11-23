package com.salesianostriana.dam.Proyecto3SpringSecurity.repository;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Inmobiliaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmobiliariaRepository extends JpaRepository<Inmobiliaria, Long> {
}
