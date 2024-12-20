package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioModel {

	private Connection cnn;

	public UsuarioModel() {
		this.cnn = Conexion.conectar();
	}

	// método para agregar un usuario
	public void agregarUsuario(Usuario usuario) {

		PreparedStatement pstm = null;
		String sql = "INSERT INTO Usuarios (rol_id, nombres, apellidos, dni_ce, correo, direccion, password, fecha_registro) VALUES (?,?,?,?,?,?,?,?)";

		try {
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, usuario.getRol_id());
			pstm.setString(2, usuario.getNombres());
			pstm.setString(3, usuario.getApellidos());
			pstm.setString(4, usuario.getDni_ce());
			pstm.setString(5, usuario.getCorreo());
			pstm.setString(6, usuario.getDireccion());
			pstm.setString(7, usuario.getPassword());
			pstm.setString(8, usuario.getFecha_registro());
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}
	}

	// método para iniciar sesión
	public int iniciarSesion(String correo, String clave) {

		PreparedStatement pstm = null;
		ResultSet rst = null;
		int usuario_id = -1;
		String sql = "SELECT usuario_id FROM Usuarios WHERE correo = ? AND password = ?";

		try {
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, correo);
			pstm.setString(2, clave);
			rst = pstm.executeQuery();

			if (rst.next()) {
				usuario_id = rst.getInt("usuario_id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return usuario_id;
	}

	// método para listar todos los usuarios activos
	public ArrayList<Usuario> listarUsuariosActivos() {

		PreparedStatement pstm = null;
		ResultSet rst = null;
		Usuario usuario;
		String sql = "SELECT * FROM usuarios WHERE fecha_baja IS NULL";
		ArrayList<Usuario> listaUsuariosList = new ArrayList<Usuario>();

		try {
			pstm = cnn.prepareStatement(sql);
			rst = pstm.executeQuery();

			while (rst.next()) {
				int usuario_id = rst.getInt("usuario_id");
				String nombres = rst.getString("nombres");
				String apellidos = rst.getString("apellidos");
				String correo = rst.getString("correo");
				String password = rst.getString("password");
				usuario = new Usuario(usuario_id, nombres, apellidos, correo, password);
				listaUsuariosList.add(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return listaUsuariosList;
	}

	// método para listar a todos los usuarios (activos y desactivados)

	// método para actualizar password
	public void actualizarPassword(Usuario usuario) {

		PreparedStatement pstm = null;

		String password = usuario.getPassword();
		String correo = usuario.getCorreo();
		String sql = "UPDATE usuarios SET password = ? WHERE correo LIKE ?";

		try {
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, password);
			pstm.setString(2, correo);
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}
	}
}
