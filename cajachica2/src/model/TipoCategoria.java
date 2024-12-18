package model;

public class TipoCategoria {

	private int categoria_id;
	private String nombre_categoria;
	private String descripcion;
	private String fecha_creacion;

	public TipoCategoria() {

	}

	public TipoCategoria(int categoria_id, String nombre_categoria) {
		this.categoria_id = categoria_id;
		this.nombre_categoria = nombre_categoria;
	}

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

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String toString() {
		return nombre_categoria;
	}

}
