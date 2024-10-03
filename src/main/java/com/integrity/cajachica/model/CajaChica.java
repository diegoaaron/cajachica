package com.integrity.cajachica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Caja_Chica") // Especifica el nombre de la tabla en la base de datos
public class CajaChica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Incremento automático
	private int caja_id;

	@Column(length = 100) // Longitud máxima para el nombre del proyecto
	private String nombre_proyecto;

	@Column(length = 100) // Longitud máxima para la descripción
	private String descripcion;

	@Column(precision = 10, scale = 2) // Para valores decimales
	private BigDecimal monto_asignado;

	@Column(nullable = false)
	private Date fecha_apertura; // Fecha de apertura

	private Date fecha_cierre; // Fecha de cierre (puede ser nula)

	@Column(nullable = false)
	private boolean estado_proyecto; // Estado del proyecto

	@ManyToOne // Relación muchos a uno con Usuarios
	@JoinColumn(name = "usuario_id", nullable = false) // Columna de unión y no puede ser nula
	private Usuarios usuario; // Objeto Usuario asociado

	// Getters y setters
	public int getCaja_id() {
		return caja_id;
	}

	public void setCaja_id(int caja_id) {
		this.caja_id = caja_id;
	}

	public String getNombre_proyecto() {
		return nombre_proyecto;
	}

	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getMonto_asignado() {
		return monto_asignado;
	}

	public void setMonto_asignado(BigDecimal monto_asignado) {
		this.monto_asignado = monto_asignado;
	}

	public Date getFecha_apertura() {
		return fecha_apertura;
	}

	public void setFecha_apertura(Date fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}

	public Date getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public boolean isEstado_proyecto() {
		return estado_proyecto;
	}

	public void setEstado_proyecto(boolean estado_proyecto) {
		this.estado_proyecto = estado_proyecto;
	}

}