package com.salesianostriana.dam.Proyecto3SpringSecurity.controller;

import com.salesianostriana.dam.Proyecto3SpringSecurity.dto.UsuarioDto.GetUsuarioDto;
import com.salesianostriana.dam.Proyecto3SpringSecurity.dto.UsuarioDto.UsuarioDtoConverter;
import com.salesianostriana.dam.Proyecto3SpringSecurity.model.Usuario;
import com.salesianostriana.dam.Proyecto3SpringSecurity.services.UsuarioServicio;
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
@RequestMapping("/propietario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;
    private final PaginationLinksUtils paginationLinksUtils;
    private final UsuarioDtoConverter usuarioDtoConverter;


    @GetMapping("/")
    public ResponseEntity<?> findAllByUserAutenticated (Pageable pageable, HttpServletRequest request, @AuthenticationPrincipal UserEntity user) {
        Page<Usuario> data = usuarioServicio.findAll(pageable);
        if (user.getRole() == UserRole.USER) {
            data = usuarioServicio.findAll(pageable);
        } else {
            data = usuarioServicio.findAllByAutenticado(user, pageable);
        }
        if (data.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Page<GetUsuarioDto> result =
                    data.map(usuarioDtoConverter::usuarioToGetUsuarioDto);

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

            return ResponseEntity.ok().header("Link",
                    paginationLinksUtils.createLinkHeader(result, uriBuilder)).body(result);
        }
    }
}
