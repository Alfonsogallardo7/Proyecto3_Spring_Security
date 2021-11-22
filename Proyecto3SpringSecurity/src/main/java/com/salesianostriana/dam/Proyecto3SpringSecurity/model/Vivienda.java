package com.salesianostriana.dam.Proyecto3SpringSecurity.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Vivienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Lob
    private String descripcion;

    @Lob
    private String avatar;

    private String lating;

    private String direccion;

    private String codigoPostal;

    private String poblacion;

    private String provincia;

    private String tipo;

    private double precio;

    private int numHabitaciones;

    private double metrosCuadrados;

    private int numBanios;

    private boolean tienePiscina;

    private boolean tieneAscensor;

    private boolean tieneGaraje;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_propietario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_inmobiliaria")
    private Inmobiliaria inmobiliaria;

    @Builder.Default
    @OneToMany(mappedBy = "vivienda", cascade = CascadeType.REMOVE)
    private List<Interesa> interesa = new ArrayList<>();

    public Vivienda(String titulo, String descripcion, String avatar, String lating, String direccion, String codigoPostal, String poblacion, String provincia, String tipo, double precio, int numHabitaciones, double metrosCuadrados, int numBanios, boolean tienePiscina, boolean tieneAscensor, boolean tieneGaraje) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.avatar = avatar;
        this.lating = lating;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.tipo = tipo;
        this.precio = precio;
        this.numHabitaciones = numHabitaciones;
        this.metrosCuadrados = metrosCuadrados;
        this.numBanios = numBanios;
        this.tienePiscina = tienePiscina;
        this.tieneAscensor = tieneAscensor;
        this.tieneGaraje = tieneGaraje;
    }

    /**
     * Cuando eliminamos un propietario, eliminamos tambien las viviendas de dicho
     * propietario en cascada
     */

    public void addInmobiliaria(Inmobiliaria inmo) {
        inmobiliaria = inmo;
        if (inmo.getViviendas() == null) {
            inmo.setViviendas(new ArrayList<>());
            inmo.getViviendas().add(this);
        } else {
            inmo.getViviendas().add(this);
        }
    }

    public void removeInmobiliaria() {
        if (this.inmobiliaria != null)
            this.inmobiliaria.getViviendas().remove(this);
        inmobiliaria = null;
    }


}
