package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RolUsuarioModel {

	private Connection cnn;

	public RolUsuarioModel() {
		this.cnn = Conexion.conectar();
	}

	// método para listar roles para un usuario
	public ArrayList<RolUsuario> listarRolesUsuario() {

		ResultSet rst = null;
		PreparedStatement pstm = null;
		RolUsuario rolUsuario;
		String sql = "SELECT * FROM rol_usuario";
		ArrayList<RolUsuario> rolUsuarioArrayList = new ArrayList<RolUsuario>();

		try {
			pstm = cnn.prepareStatement(sql);
			rst = pstm.executeQuery();

			if (rst.next()) {
				rolUsuario = new RolUsuario(rst.getInt("rol_id"), rst.getString("nombre_rol"));
				rolUsuarioArrayList.add(rolUsuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return rolUsuarioArrayList;
	}

}
