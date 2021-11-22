package com.salesianostriana.dam.Proyecto3SpringSecurity.users.repository;

import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserEntityRepository
extends JpaRepository <UserEntity, Long> {

    Optional<UserEntity> findFirstByEmail(String email);
}
