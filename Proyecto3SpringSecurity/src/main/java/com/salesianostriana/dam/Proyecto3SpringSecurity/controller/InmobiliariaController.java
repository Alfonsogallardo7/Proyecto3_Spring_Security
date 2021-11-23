package com.salesianostriana.dam.Proyecto3SpringSecurity.controller;

import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Inmobiliaria;
import com.salesianostriana.dam.Proyecto3SpringSecurity.services.base.InmobiliariaServicio;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserRole;
import com.salesianostriana.dam.Proyecto3SpringSecurity.util.PaginationLinksUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/inmobiliaria")
@RequiredArgsConstructor
public class InmobiliariaController {

    private final InmobiliariaServicio inmobiliariaServicio;
    private final PaginationLinksUtils paginationLinksUtils;
    private final InmobiliariaDtoConverter inmobiliariaDtoConverter;

    /*
    Preguntar a luismi si hay que lanza una excepcion, como en el proyecto de ow
     */
    @GetMapping("/gestor/")
    public ResponseEntity<?> findAllByGestor(Pageable pageable, HttpServletRequest request, @AuthenticationPrincipal UserEntity user) {
        Page<Inmobiliaria> data = inmobiliariaServicio.findAll(pageable);
        if (user.getRole().contains(UserRole.GESTOR)) {
            data = inmobiliariaServicio.findAll(pageable);
        }else {
            data = inmobiliariaServicio.findAllByUser(user, pageable);
        }
        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Page<GetInmobiliariaDto> result=
                    data.map(inmobiliariaDtoConverter::inmobiliariaToGetInmobiliariaDto);

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

            return ResponseEntity.ok().header("Link",
                    paginationLinksUtils.createLinkHeader(result, uriBuilder)).body(result);
        }
    }
}
