package model;

public class RolUsuario {

	private int rol_id;
	private String nombre_rol;
	private String descripcion;
	private String fecha_creacion;

	public RolUsuario() {
		this.rol_id = -1;
		this.nombre_rol = "";
		this.descripcion = "";
		this.fecha_creacion = "";

	}

	public RolUsuario(int rol_id, String nombre_rol) {
		this.rol_id = rol_id;
		this.nombre_rol = nombre_rol;
	}

	public RolUsuario(int rol_id, String nombre_rol, String descripcion, String fecha_creacion) {
		this.rol_id = rol_id;
		this.nombre_rol = nombre_rol;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String toString() {
		return nombre_rol;
	}

}
