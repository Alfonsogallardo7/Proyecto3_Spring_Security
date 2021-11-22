package com.salesianostriana.dam.Proyecto3SpringSecurity.users.dto;

import com.salesianostriana.dam.Proyecto3SpringSecurity.users.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
        return GetUserDto.builder()
                .avatar(user.getAvatar())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
