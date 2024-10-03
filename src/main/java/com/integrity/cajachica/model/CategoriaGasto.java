package com.integrity.cajachica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Categoria_Gasto") // Especifica el nombre de la tabla en la base de datos
public class CategoriaGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Incremento automático
    private int categoria_id;

    @Column(nullable = false, length = 50) // Longitud máxima para el nombre de la categoría
    private String nombre_categoria;

    @Column(nullable = false, length = 100) // Longitud máxima para la descripción
    private String descripcion;

    @Column(nullable = false) // Fecha de creación no puede ser nula
    private Date fecha_creacion; // Utiliza java.sql.Date para fechas

    // Getters y setters
    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}