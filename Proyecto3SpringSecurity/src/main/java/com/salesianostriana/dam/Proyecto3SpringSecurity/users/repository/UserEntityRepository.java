package com.salesianostriana.dam.Proyecto3SpringSecurity.users.repository;

import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

public interface UserEntityRepository
extends JpaRepository <Entity, Long> {

    Optional<UserEntity> findFirstByEmail(String email);
}
