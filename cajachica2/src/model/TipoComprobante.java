package model;

public class TipoComprobante {

	private int tipo_comprobante_id;
	private String nombre_tipo_comprobante;
	private String descripcion;
	private String fecha_creacion;

	public TipoComprobante() {

	}

	public TipoComprobante(int tipo_comprobante_id, String nombre_tipo_comprobante) {
		this.tipo_comprobante_id = tipo_comprobante_id;
		this.nombre_tipo_comprobante = nombre_tipo_comprobante;
	}

	public int getTipo_comprobante_id() {
		return tipo_comprobante_id;
	}

	public void setTipo_comprobante_id(int tipo_comprobante_id) {
		this.tipo_comprobante_id = tipo_comprobante_id;
	}

	public String getNombre_tipo_comprobante() {
		return nombre_tipo_comprobante;
	}

	public void setNombre_tipo_comprobante(String nombre_tipo_comprobante) {
		this.nombre_tipo_comprobante = nombre_tipo_comprobante;
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
		return nombre_tipo_comprobante;

	}
}
