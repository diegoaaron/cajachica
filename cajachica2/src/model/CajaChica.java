package model;

public class CajaChica {

	private int caja_id;
	private int usuario_id;
	private String nombre_proyecto;
	private String descripcion;
	private double monto_asignado;
	private double monto_gastado;
	private double monto_cierre;
	private String fecha_apertura;
	private String fecha_cierre;
	private String estado_proyecto;

	public CajaChica() {
		this.caja_id = -1;
		this.usuario_id = -1;
		this.nombre_proyecto = "";
		this.descripcion = "";
		this.monto_asignado = -1.0;
		this.monto_gastado = -1.0;
		this.monto_cierre = -1.0;
		this.fecha_apertura = "";
		this.fecha_cierre = "";
		this.estado_proyecto = "";
	}

	public CajaChica(int caja_id, int usuario_id, String nombre_proyecto, double monto_asignado) {
		this.usuario_id = usuario_id;
		this.nombre_proyecto = nombre_proyecto;
		this.monto_asignado = monto_asignado;
		this.caja_id = caja_id;
	}

	public CajaChica(int usuario_id, String nombre_proyecto, String descripcion, double monto_asignado,
			double monto_gastado, double monto_cierre, String fecha_apertura, String fecha_cierre,
			String estado_proyecto) {
		this.usuario_id = usuario_id;
		this.nombre_proyecto = nombre_proyecto;
		this.descripcion = descripcion;
		this.monto_asignado = monto_asignado;
		this.monto_gastado = monto_gastado;
		this.monto_cierre = monto_cierre;
		this.fecha_apertura = fecha_apertura;
		this.fecha_cierre = fecha_cierre;
		this.estado_proyecto = estado_proyecto;
	}

	public int getCaja_id() {
		return caja_id;
	}

	public void setCaja_id(int caja_id) {
		this.caja_id = caja_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
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

	public double getMonto_asignado() {
		return monto_asignado;
	}

	public void setMonto_asignado(double monto_asignado) {
		this.monto_asignado = monto_asignado;
	}

	public double getMonto_gastado() {
		return monto_gastado;
	}

	public void setMonto_gastado(double monto_gastado) {
		this.monto_gastado = monto_gastado;
	}

	public double getMonto_cierre() {
		return monto_cierre;
	}

	public void setMonto_cierre(double monto_cierre) {
		this.monto_cierre = monto_cierre;
	}

	public String getFecha_apertura() {
		return fecha_apertura;
	}

	public void setFecha_apertura(String fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}

	public String getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(String fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public String getEstado_proyecto() {
		return estado_proyecto;
	}

	public void setEstado_proyecto(String estado_proyecto) {
		this.estado_proyecto = estado_proyecto;
	}

	public String toString() {
		return nombre_proyecto;
	}

}
