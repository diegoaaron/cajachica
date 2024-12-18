package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.RolUsuario;

public class Rol_Usuario_Controller {

	private final Connection cnn;
	private ArrayList<RolUsuario> rolUsuarioArrayList;

	public Rol_Usuario_Controller(Connection cnn) {
		this.cnn = cnn;
	}

	public ArrayList<RolUsuario> listaRolUsuario() {
		Statement st = null;
		ResultSet rs = null;
		RolUsuario rolUsuario;
		rolUsuarioArrayList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Rol_Usuario";
			st = cnn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				int rol_id = rs.getInt("rol_id");
				String nombre_rol = rs.getString("nombre_rol");
				rolUsuario = new RolUsuario(rol_id, nombre_rol);
				rolUsuarioArrayList.add(rolUsuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(st, rs);
		}

		return rolUsuarioArrayList;
	}

}
