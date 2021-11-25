package com.salesianostriana.dam.Proyecto3SpringSecurity.controller;

import com.salesianostriana.dam.Proyecto3SpringSecurity.dto.InmobiliariaDto.GetInmobiliariaDto;
import com.salesianostriana.dam.Proyecto3SpringSecurity.dto.InmobiliariaDto.InmobiliariaDtoConverter;
import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Inmobiliaria;
import com.salesianostriana.dam.Proyecto3SpringSecurity.services.InmobiliariaServicio;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserRole;
import com.salesianostriana.dam.Proyecto3SpringSecurity.util.PaginationLinksUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/inmobiliaria")
@RequiredArgsConstructor
public class InmobiliariaController {

    private final InmobiliariaServicio inmobiliariaServicio;
    private final PaginationLinksUtils paginationLinksUtils;
    private final InmobiliariaDtoConverter inmobiliariaDtoConverter;

    @GetMapping("/{id}/gestor/")
    public ResponseEntity<?> findAllByGestorOrAdmin(Pageable pageable, HttpServletRequest request, @AuthenticationPrincipal UserEntity user) {
        Page<Inmobiliaria> data = inmobiliariaServicio.findAll(pageable);
        if ((user.getRole()==UserRole.GESTOR)||(user.getRole()==UserRole.ADMIN)) {
            data = inmobiliariaServicio.findAll(pageable);
        }
        else {
            data = inmobiliariaServicio.findAllByGestor(user, pageable);
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

    @GetMapping("/")
    public ResponseEntity<?> findAllByUserAutenticated (Pageable pageable, HttpServletRequest request, @AuthenticationPrincipal UserEntity user) {
        Page<Inmobiliaria> data = inmobiliariaServicio.findAll(pageable);
        if (user.getRole() == UserRole.USER) {
            data = inmobiliariaServicio.findAll(pageable);
        } else {
            data = inmobiliariaServicio.findAllByAutenticado(user, pageable);
        }
        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Page<GetInmobiliariaDto> result =
                    data.map(inmobiliariaDtoConverter::inmobiliariaToGetInmobiliariaDto);

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

            return ResponseEntity.ok().header("Link",
                    paginationLinksUtils.createLinkHeader(result, uriBuilder)).body(result);
        }
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<?> findByIdByUserAutenticado (@PathVariable Long id, @AuthenticationPrincipal UserEntity user) {
        Optional<Inmobiliaria> inmobiliariaBuscada = inmobiliariaServicio.findById(id);
        if (user.getRole() == UserRole.USER){
            if (inmobiliariaBuscada.isEmpty())
                return ResponseEntity.notFound().build();
            else
                return ResponseEntity.ok().body(inmobiliariaDtoConverter.inmobiliariaToGetInmobiliariaDto(inmobiliariaBuscada.get()));
        } else {

        }


    }**/
}
