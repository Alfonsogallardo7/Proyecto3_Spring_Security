package com.salesianostriana.dam.Proyecto3SpringSecurity.users.controller;

import com.salesianostriana.dam.Proyecto3SpringSecurity.users.dto.CreateUserDto;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.dto.GetUserDto;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.dto.UserDtoConverter;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import com.salesianostriana.dam.Proyecto3SpringSecurity.users.services.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllers {
    private final UserEntityService userEntityService;
    private final UserDtoConverter userDtoConverter;

    @PostMapping("/auth/register/user")
    public ResponseEntity<GetUserDto> nuevoUsuario(@RequestBody CreateUserDto newUser) {
        UserEntity saved = userEntityService.save(newUser);

        if (saved == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(userDtoConverter.convertUserEntityToGetUserDto(saved));
    }

    @GetMapping("/me")
    public GetUserDto me (@AuthenticationPrincipal UserEntity user) {
        return userDtoConverter.convertUserEntityToGetUserDto(user);
    }

}
