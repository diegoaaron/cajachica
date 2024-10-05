package com.integrity.cajachica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "Usuarios") // Especifica el nombre de la tabla en la base de datos
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;

    @Column(nullable = false, length = 100) // Configura restricciones para la columna
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 12)
    private String dni_ce;

    @Column(nullable = false)
    private java.sql.Date fecha_nacimiento; // Utiliza java.sql.Date para fechas

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private java.sql.Date fecha_registro;

    @Column(nullable = true) // Permitir que sea nulo
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Especifica el formato esperado
    private java.sql.Date fecha_baja; // Puede ser nulo

    @ManyToOne // Indica que muchos usuarios pueden tener un rol
    @JoinColumn(name = "rol_id", nullable = false) // Especifica la columna de unión y que no puede ser nula
    private Rol rol; // Cambiamos el tipo a Rol en lugar de int

    // Getters y setters
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni_ce() {
        return dni_ce;
    }

    public void setDni_ce(String dni_ce) {
        this.dni_ce = dni_ce;
    }

    public java.sql.Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(java.sql.Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(java.sql.Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public java.sql.Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(java.sql.Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

   // Método para obtener el rol asociado al usuario
   public Rol getRol() {
       return rol;
   }

   // Método para establecer el rol asociado al usuario
   public void setRol(Rol rol) {
       this.rol = rol;
   }
}