package controller;

import java.util.ArrayList;

import model.Usuario;
import model.UsuarioModel;

public class UsuarioController {

	public UsuarioController() {

	}

	// método para agregar un usuario
	public void agregarUsuario(int rol_id, String nombres, String apellidos, String dni_ce, String correo,
			String direccion, String password, String fecha_registro) {

		UsuarioModel usuarioModel = new UsuarioModel();
		Usuario usuario = null;

		try {
			usuario = new Usuario(rol_id, nombres, apellidos, dni_ce, correo, direccion, password, fecha_registro);
			usuarioModel.agregarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// método para iniciar sesión
	public int iniciarSesion(String correo, String clave) {

		int usuario_id = -1;
		UsuarioModel usuarioModel = new UsuarioModel();

		try {
			usuario_id = usuarioModel.iniciarSesion(correo, clave);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario_id;
	}

	// método para listar todos los usuarios activos
	public ArrayList<Usuario> listarUsuariosActivos() {

		UsuarioModel usuarioModel = new UsuarioModel();
		ArrayList<Usuario> listaUsuariosList = new ArrayList<Usuario>();

		try {
			listaUsuariosList = usuarioModel.listarUsuariosActivos();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaUsuariosList;
	}

	// método para actualizar password
	public void actualizarPassword(String nuevoPassword, int usuario_id) {

		UsuarioModel usuarioModel = new UsuarioModel();

		try {
			usuarioModel.actualizarPassword(nuevoPassword, usuario_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
