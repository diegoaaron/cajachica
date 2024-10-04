package com.integrity.cajachica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles") // Especifica el nombre de la tabla en la base de datos
public class Roles {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rol_id;

    @Column(nullable = false, length = 50) // Configura restricciones para la columna
    private String nombre_rol;

    // Getters y setters
    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }


}