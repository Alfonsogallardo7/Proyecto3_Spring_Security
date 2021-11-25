package com.salesianostriana.dam.Proyecto3SpringSecurity.services;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Vivienda;
import com.salesianostriana.dam.Proyecto3SpringSecurity.repository.ViviendaRepository;
import com.salesianostriana.dam.Proyecto3SpringSecurity.services.base.BaseService;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViviendaServicio extends BaseService<Vivienda, Long, ViviendaRepository> {

    public Page<Vivienda> findAllByAutenticado (UserEntity user, Pageable pageable) {
        return repositorio.findByAutenticado(user, pageable);
    }
}
