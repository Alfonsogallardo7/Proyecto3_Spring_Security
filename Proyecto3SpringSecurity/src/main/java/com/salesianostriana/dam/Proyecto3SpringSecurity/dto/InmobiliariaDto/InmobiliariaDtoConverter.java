package com.salesianostriana.dam.Proyecto3SpringSecurity.dto.InmobiliariaDto;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Inmobiliaria;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class InmobiliariaDtoConverter {

    public Inmobiliaria createInmobiliariaDtoToInmobiliaria (CreateInmobiliariaDto createInmobiliariaDto) {
        return new Inmobiliaria(
                createInmobiliariaDto.getNombre(),
                createInmobiliariaDto.getTelefono(),
                createInmobiliariaDto.getEmail()
        );
    }

    public GetInmobiliariaDto inmobiliariaToGetInmobiliariaDto(Inmobiliaria inmobiliaria) {
        return GetInmobiliariaDto.builder()
                .nombre(inmobiliaria.getNombre())
                .email(inmobiliaria.getEmail())
                .telefono(inmobiliaria.getTelefono())
                /* Hay que hacerlo si no queremos que salga la recursividad

                .viviendas(inmobiliaria.getViviendas().stream()
                        .map(this::inmobiliariaToGetInmobiliariaDto)
                        .collect(Collectors.toSet())
                )
                .usuarios(inmobiliaria.getUsuarios().stream()
                        .map(this::inmobiliariaToGetInmobiliariaDto)
                        .collect(Collectors.toSet())
                )*/
                .viviendas(inmobiliaria.getViviendas())
                .usuarios(inmobiliaria.getUsuarios())
                .build();
    }
}
