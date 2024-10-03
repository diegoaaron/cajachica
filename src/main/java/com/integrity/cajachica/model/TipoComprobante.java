package com.integrity.cajachica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Tipo_Comprobante") // Especifica el nombre de la tabla en la base de datos
public class TipoComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Incremento automático
    private int tipo_comprobante_id;

    @Column(nullable = false, length = 50) // Longitud máxima para el nombre del tipo de comprobante
    private String nombre_tipo_categoria;

    @Column(nullable = false, length = 100) // Longitud máxima para la descripción
    private String descripcion;

    @Column(nullable = false) // Fecha de creación no puede ser nula
    private Date fecha_creacion; // Utiliza java.sql.Date para fechas

    // Getters y setters
    public int getTipo_comprobante_id() {
        return tipo_comprobante_id;
    }

    public void setTipo_comprobante_id(int tipo_comprobante_id) {
        this.tipo_comprobante_id = tipo_comprobante_id;
    }

    public String getNombre_tipo_categoria() {
        return nombre_tipo_categoria;
    }

    public void setNombre_tipo_categoria(String nombre_tipo_categoria) {
        this.nombre_tipo_categoria = nombre_tipo_categoria;
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