package com.salesianostriana.dam.Proyecto3SpringSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class InteresaPk implements Serializable {

    private Long vivienda_id;
    private Long usuario_id;

}
