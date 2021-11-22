package com.salesianostriana.dam.Proyecto3SpringSecurity.users.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {

    private String username, avatar, fullName, email, password, password2;

}
