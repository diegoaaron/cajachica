package model;

public class RendicionGastos {

	private int rendicion_id;
	private int caja_id;
	private int categoria_id;
	private int tipo_comprobante_id;
	private String num_comprobante;
	private String descripcion_gasto;
	private double monto;
	private String fecha_registro;
	private String estado_aprobacion;

	public RendicionGastos() {

	}

	// constructor para agregar rendiciones de gastos
	public RendicionGastos(int caja_id, int categoria_id, int tipo_comprobante_id, String num_comprobante,
			String descripcion_gasto, double monto, String fecha_registro, String estado_aprobacion) {
		this.caja_id = caja_id;
		this.categoria_id = categoria_id;
		this.tipo_comprobante_id = tipo_comprobante_id;
		this.num_comprobante = num_comprobante;
		this.descripcion_gasto = descripcion_gasto;
		this.monto = monto;
		this.fecha_registro = fecha_registro;
		this.estado_aprobacion = estado_aprobacion;
	}

	public RendicionGastos(int rendicion_id, int caja_id, int categoria_id, int tipo_comprobante_id,
			String num_comprobante, String descripcion_gasto, double monto, String fecha_registro,
			String estado_aprobacion) {
		this.rendicion_id = rendicion_id;
		this.caja_id = caja_id;
		this.categoria_id = categoria_id;
		this.tipo_comprobante_id = tipo_comprobante_id;
		this.num_comprobante = num_comprobante;
		this.descripcion_gasto = descripcion_gasto;
		this.monto = monto;
		this.fecha_registro = fecha_registro;
		this.estado_aprobacion = estado_aprobacion;
	}

	public int getRendicion_id() {
		return rendicion_id;
	}

	public void setRendicion_id(int rendicion_id) {
		this.rendicion_id = rendicion_id;
	}

	public int getCaja_id() {
		return caja_id;
	}

	public void setCaja_id(int caja_id) {
		this.caja_id = caja_id;
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}

	public int getTipo_comprobante_id() {
		return tipo_comprobante_id;
	}

	public void setTipo_comprobante_id(int tipo_comprobante_id) {
		this.tipo_comprobante_id = tipo_comprobante_id;
	}

	public String getNum_comprobante() {
		return num_comprobante;
	}

	public void setNum_comprobante(String num_comprobante) {
		this.num_comprobante = num_comprobante;
	}

	public String getDescripcion_gasto() {
		return descripcion_gasto;
	}

	public void setDescripcion_gasto(String descripcion_gasto) {
		this.descripcion_gasto = descripcion_gasto;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getEstado_aprobacion() {
		return estado_aprobacion;
	}

	public void setEstado_aprobacion(String estado_aprobacion) {
		this.estado_aprobacion = estado_aprobacion;
	}
}
