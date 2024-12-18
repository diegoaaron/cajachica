package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import model.CajaChica;

public class RegistroCajaChicaController {

	private final Connection cnn;

	private CajaChica registroCajaChicaProyecto;

	private ArrayList<CajaChica> cajasChicasArrayList = new ArrayList<CajaChica>();

	public RegistroCajaChicaController(Connection cnn) {
		this.cnn = cnn;
	}

	public void insertar(CajaChica registroCajaChica) {
		PreparedStatement sentencia = null;

		int usuario_id = registroCajaChica.getUsuario_id();
		String nombre_proyecto = registroCajaChica.getNombre_proyecto();
		String descripcion = registroCajaChica.getDescripcion();
		double monto_asignado = registroCajaChica.getMonto_asignado();
		double monto_gastado = registroCajaChica.getMonto_gastado();
		double monto_cierre = registroCajaChica.getMonto_cierre();
		String fecha_apertura = registroCajaChica.getFecha_apertura();
		String fecha_cierre = registroCajaChica.getFecha_cierre();

		try {
			String sql = "INSERT INTO Caja_Chica (usuario_id, nombre_proyecto, descripcion, monto_asignado, monto_gastado, monto_cierre, fecha_apertura, fecha_cierre) VALUES (?,?,?,?,?,?,?,?)";
			sentencia = cnn.prepareStatement(sql);

			sentencia.setInt(1, usuario_id);
			sentencia.setString(2, nombre_proyecto);
			sentencia.setString(3, descripcion);
			sentencia.setDouble(4, monto_asignado);
			sentencia.setDouble(5, monto_gastado);
			sentencia.setDouble(6, monto_cierre);
			sentencia.setString(7, fecha_apertura);
			sentencia.setString(8, fecha_cierre);

			sentencia.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CajaChica listarCajaPorUsuario(int usuario_id) {
		PreparedStatement sentencia = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM Caja_Chica where usuario_id = ?";

			sentencia = cnn.prepareStatement(sql);

			sentencia.setInt(1, usuario_id);

			rs = sentencia.executeQuery();

			while (rs.next()) {

				int caja_id_t = rs.getInt("caja_id");
				int usuario_id_t = rs.getInt("usuario_id");
				String nombre_proyecto_t = rs.getString("nombre_proyecto");
				double monto_asignado_t = rs.getDouble("monto_asignado");

				registroCajaChicaProyecto = new CajaChica(caja_id_t, usuario_id_t, nombre_proyecto_t,
						monto_asignado_t);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return registroCajaChicaProyecto;
	}

	public ArrayList<CajaChica> listarCajasAbiertas() {
		PreparedStatement sentencia = null;
		ResultSet rs = null;

		try {
			String sql = "select * from caja_chica where estado_proyecto = ?";

			sentencia = cnn.prepareStatement(sql);

			sentencia.setString(1, "");

			rs = sentencia.executeQuery();

			while (rs.next()) {

				int caja_id_t = rs.getInt("caja_id");
				int usuario_id_t = rs.getInt("usuario_id");
				String nombre_proyecto_t = rs.getString("nombre_proyecto");
				double monto_asignado_t = rs.getDouble("monto_asignado");

				registroCajaChicaProyecto = new CajaChica(caja_id_t, usuario_id_t, nombre_proyecto_t,
						monto_asignado_t);

				cajasChicasArrayList.add(registroCajaChicaProyecto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cajasChicasArrayList;
	}

	public void aprobarCajaChica(int caja_id) {
		PreparedStatement sentencia = null;

		try {
			sentencia = cnn.prepareStatement("UPDATE Caja_Chica SET estado_proyecto = ? WHERE caja_id == ?");

			sentencia.setString(1, "aprobado");
			sentencia.setInt(2, caja_id);

			sentencia.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(sentencia);
		}
	}

}
