package com.salesianostriana.dam.Proyecto3SpringSecurity.dto.InmobiliariaDto;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Usuario;
import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Vivienda;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
public class CreateInmobiliariaDto {
    private String nombre, email, telefono;
    private List<Vivienda> vivienda_id;
}
