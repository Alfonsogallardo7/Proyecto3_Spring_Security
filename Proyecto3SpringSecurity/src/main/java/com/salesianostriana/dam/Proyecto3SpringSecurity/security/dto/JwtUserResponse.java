package com.salesianostriana.dam.Proyecto3SpringSecurity.security.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class JwtUserResponse {

    private String email;
    private String fullName;
    private String avatar;
    private String role;
    private String token;
}
