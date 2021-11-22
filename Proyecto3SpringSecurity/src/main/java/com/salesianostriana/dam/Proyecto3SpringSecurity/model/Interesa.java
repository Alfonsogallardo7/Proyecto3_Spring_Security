package com.salesianostriana.dam.Proyecto3SpringSecurity.model;

import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Interesa implements Serializable {

    @Builder.Default
    @EmbeddedId
    private InteresaPk id = new InteresaPk();

    @ManyToOne
    @MapsId("vivienda_id")
    @JoinColumn(name = "vivienda_id")
    private Vivienda vivienda;

    @ManyToOne
    @MapsId("usuario_id")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate createdDate;

    @Lob
    private String mensaje;

    public Interesa(LocalDate createdDate, String mensaje) {
        this.createdDate = createdDate;
        this.mensaje = mensaje;
    }

    /*Helpers*/

    public void addToVivienda(Vivienda v){
        vivienda =v;
        v.getInteresa().add(this);
    }

    public void removeFromVivienda(Vivienda v){
        v.getInteresa().remove(this);
    }

    public void addToUsuario(Usuario u) {
        usuario = u;
        u.getInteresa().add(this);
    }

    public void removeFromUsuario(Usuario u) {
        u.getInteresa().remove(this);
        usuario = null;
    }
    /* Este metodo helper será para añadir un usuario interesado con rol propietario*/
    public void addUsuarioVivienda(Usuario usuario, Vivienda vivienda) {
    addToVivienda(vivienda);
    addToUsuario((Usuario) usuario);
    }

    public void removeUsuarioVivienda(Usuario usuario, Vivienda vivienda) {
        removeFromVivienda(vivienda);
        removeFromUsuario((Usuario) usuario);
    }
}
