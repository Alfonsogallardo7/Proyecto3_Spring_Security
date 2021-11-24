package com.salesianostriana.dam.Proyecto3SpringSecurity.dto.InmobiliariaDto;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Inmobiliaria;
import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Usuario;
import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Vivienda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInmobiliariaDto {

    private String nombre, email, telefono;
    private List<Vivienda> viviendas;
    private List<Usuario> usuarios;
}
