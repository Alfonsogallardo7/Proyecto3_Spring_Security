package com.salesianostriana.dam.Proyecto3SpringSecurity.services.base;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Inmobiliaria;
import com.salesianostriana.dam.Proyecto3SpringSecurity.repository.InmobiliariaRepository;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class InmobiliariaServicio extends BaseService<Inmobiliaria, Long, InmobiliariaRepository> {

   /* public ResponseEntity<Inmobiliaria> nuevaInmobiliaria(CreateInmobiliariaDto nuevo, UserEntity cliente) {
        El método de el proyecto 1
        if (nuevaInmobiliaria.getNombre() == null){
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(inmoService.save(nuevaInmo));


        }
    }*/
    /**
     * Este es el método empezado del repositorio de ow, ver si me hace falta y completar
        return save(Inmobiliaria.builder()
                .usuarios(cliente)
                .viviendas(nuevo.getViviendas().stream()
                        .map(viviendaDto -> {
                            Optional<>
                        }
    })).build())
    }**/

    public Page<Inmobiliaria> findAllByUser (UserEntity user, Pageable pageable) {
        return repositorio.findByCliente(user, pageable);
    }
}
