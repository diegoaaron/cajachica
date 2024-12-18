package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CajaChicaModel {

	private Connection cnn;

	public CajaChicaModel() {
		this.cnn = Conexion.conectar();
	}

	// método para agregar una caja chica
	public void agregarCaja(CajaChica cajaChica) {

		PreparedStatement pstm = null;

		int usuario_id = cajaChica.getUsuario_id();
		String nombre_proyecto = cajaChica.getNombre_proyecto();
		String descripcion = cajaChica.getDescripcion();
		double monto_asignado = cajaChica.getMonto_asignado();
		double monto_gastado = cajaChica.getMonto_gastado();
		double monto_cierre = cajaChica.getMonto_cierre();
		String fecha_apertura = cajaChica.getFecha_apertura();
		String fecha_cierre = cajaChica.getFecha_cierre();

		String sql = "INSERT INTO caja_chica (usuario_id, nombre_proyecto, descripcion, monto_asignado, monto_gastado, monto_cierre, fecha_apertura, fecha_cierre) VALUES (?,?,?,?,?,?,?,?)";

		try {
			pstm = cnn.prepareStatement(sql);

			pstm.setInt(1, usuario_id);
			pstm.setString(2, nombre_proyecto);
			pstm.setString(3, descripcion);
			pstm.setDouble(4, monto_asignado);
			pstm.setDouble(5, monto_gastado);
			pstm.setDouble(6, monto_cierre);
			pstm.setString(7, fecha_apertura);
			pstm.setString(8, fecha_cierre);

			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}
	}

	// método para listar cajas por usuario
	public CajaChica listarCajasPorUsuario(int usuario_id) {

		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM caja_chica where usuario_id = ?";
		CajaChica cajaChica = null;

		try {
			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, usuario_id);

			rst = pstm.executeQuery();

			while (rst.next()) {

				int caja_id_t = rst.getInt("caja_id");
				int usuario_id_t = rst.getInt("usuario_id");
				String nombre_proyecto_t = rst.getString("nombre_proyecto");
				double monto_asignado_t = rst.getDouble("monto_asignado");

				cajaChica = new CajaChica(caja_id_t, usuario_id_t, nombre_proyecto_t, monto_asignado_t);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return cajaChica;
	}

	// método para listar todas las cajas abiertas
	public ArrayList<CajaChica> listarCajasAbiertas() {

		PreparedStatement pstm = null;
		ResultSet rst = null;
		CajaChica cajaChica = null;
		ArrayList<CajaChica> cajasChicasArrayList = new ArrayList<CajaChica>();
		String sql = "SELECT * FROM caja_chica WHERE estado_proyecto = ?";

		try {
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, "");

			rst = pstm.executeQuery();

			while (rst.next()) {

				int caja_id_t = rst.getInt("caja_id");
				int usuario_id_t = rst.getInt("usuario_id");
				String nombre_proyecto_t = rst.getString("nombre_proyecto");
				double monto_asignado_t = rst.getDouble("monto_asignado");

				cajaChica = new CajaChica(caja_id_t, usuario_id_t, nombre_proyecto_t, monto_asignado_t);
				cajasChicasArrayList.add(cajaChica);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return cajasChicasArrayList;
	}

	// método para aprobar una caja chica
	public void aprobarCajaChica(int caja_id) {

		PreparedStatement pstm = null;
		String sql = "UPDATE caja_chica SET estado_proyecto = ? WHERE caja_id == ?";

		try {
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, "aprobado");
			pstm.setInt(2, caja_id);
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}
	}

}
