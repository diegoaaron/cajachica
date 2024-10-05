package com.integrity.cajachica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.Set;



@Entity
@Table(name = "Rol") // Especifica el nombre de la tabla en la base de datos
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rol_id;

    @Column(nullable = false, unique = true, length = 50) // Configura restricciones para la columna
    public String nombrerol;

	@Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false)
    private Date fecha_creacion; // Utiliza java.sql.Date para fechas
    
    @OneToMany(mappedBy = "rol", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Usuarios> usuarios;

    // Getters y setters
    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getNombrerol() {
		return nombrerol;
	}

	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
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