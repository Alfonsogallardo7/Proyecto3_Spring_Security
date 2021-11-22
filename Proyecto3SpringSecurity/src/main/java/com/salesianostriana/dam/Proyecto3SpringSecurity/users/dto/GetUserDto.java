package com.salesianostriana.dam.Proyecto3SpringSecurity.users.dto;

import lombok.*;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserDto {
    private String avatar, fullName, email, role;
}
