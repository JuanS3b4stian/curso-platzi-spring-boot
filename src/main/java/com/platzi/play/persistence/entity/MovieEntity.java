package com.platzi.play.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "platzi_play_peliculas")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String titulo;

    @Column(nullable = false, precision = 3)
    private Integer duracion;

    @Column(nullable = false, length = 40)
    private String genero;

    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;

    @Column(precision = 3, scale = 2)
    private BigDecimal clasificacion;

    @Column (nullable = false, length = 1)
    private String estado;

    // Getters

    public BigDecimal getClasificacion() {
        return clasificacion;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId(){
        return id;
    }

    // Setters

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setClasificacion(BigDecimal clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setId(Long id){
        this.id = id;
    }
}
