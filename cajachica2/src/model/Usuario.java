package model;

public class Usuario {

	private int usuario_id;
	private int rol_id;
	private String nombres;
	private String apellidos;
	private String dni_ce;
	private String correo;
	private String direccion;
	private String password;
	private String fecha_registro;
	private String fecha_baja;

	public Usuario() {
		this.usuario_id = -1;
		this.rol_id = -1;
		this.nombres = "";
		this.apellidos = "";
		this.dni_ce = "";
		this.correo = "";
		this.direccion = "";
		this.password = "";
		this.fecha_registro = "";
		this.fecha_baja = "";
	}

	// constructor para listar usuarios activos
	public Usuario(int usuario_id, String nombres, String apellidos, String correo, String password) {
		this.usuario_id = usuario_id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
	}

	// constructor para agregar un nuevo usuario
	public Usuario(int rol_id, String nombres, String apellidos, String dni_ce, String correo, String direccion,
			String password, String fecha_registro) {
		this.rol_id = rol_id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni_ce = dni_ce;
		this.correo = correo;
		this.direccion = direccion;
		this.password = password;
		this.fecha_registro = fecha_registro;
	}

	public Usuario(int usuario_id, int rol_id, String nombres, String apellidos, String dni_ce, String correo,
			String direccion, String password, String fecha_registro, String fecha_baja) {
		this.usuario_id = usuario_id;
		this.rol_id = rol_id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni_ce = dni_ce;
		this.correo = correo;
		this.direccion = direccion;
		this.password = password;
		this.fecha_registro = fecha_registro;
		this.fecha_baja = fecha_baja;
	}

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

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public int getRol_id() {
		return rol_id;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	public String toString() {
		return correo;
	}
}