package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RendicionGastosModel {

	private Connection cnn;

	public RendicionGastosModel() {
		this.cnn = Conexion.conectar();
	}

	// método para agregar una rendicion de gasto de un usuario
	public void agregarRendicion(RendicionGastos rendicionGastos) {

		PreparedStatement pstm = null;

		int caja_id = rendicionGastos.getCaja_id();
		int categoria_id = rendicionGastos.getCategoria_id();
		int tipo_comprobante_id = rendicionGastos.getTipo_comprobante_id();
		String num_comprobante = rendicionGastos.getNum_comprobante();
		String descripcion_gasto = rendicionGastos.getDescripcion_gasto();
		double monto = rendicionGastos.getMonto();
		String fecha_registro = rendicionGastos.getFecha_registro();
		String estado_aprobacion = rendicionGastos.getEstado_aprobacion();

		String sql = "INSERT INTO rendicion_gastos (caja_id, categoria_id, tipo_comprobante_id, num_comprobante, descripcion_gasto, monto, fecha_registro, estado_aprobacion) VALUES (?,?,?,?,?,?,?,?)";

		try {
			pstm = cnn.prepareStatement(sql);

			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, caja_id);
			pstm.setInt(2, categoria_id);
			pstm.setInt(3, tipo_comprobante_id);
			pstm.setString(4, num_comprobante);
			pstm.setString(5, descripcion_gasto);
			pstm.setDouble(6, monto);
			pstm.setString(7, fecha_registro);
			pstm.setString(8, estado_aprobacion);

			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}
	}

	// método para obtener rendiciones de gastos filtradas por id de caja chica
	public ArrayList<RendicionGastos> obtenerGastosPorCajaChica(int cajaId) {

		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM rendicion_gastos WHERE caja_id = ?";
		RendicionGastos rendicionGastos = null;
		ArrayList<RendicionGastos> rendicionesPorCajaChicaList = new ArrayList<RendicionGastos>();

		try {

			pstm = cnn.prepareStatement(sql);
			pstm.setInt(1, cajaId);

			rst = pstm.executeQuery();

			while (rst.next()) {
				int rendicion_id = rst.getInt("rendicion_id");
				int caja_id = rst.getInt("caja_id");
				int categoria_id = rst.getInt("categoria_id");
				int tipo_comprobante_id = rst.getInt("tipo_comprobante_id");
				String num_comprobante = rst.getString("num_comprobante");
				String descripcion_gasto = rst.getString("descripcion_gasto");
				double monto = rst.getDouble("monto");
				String fecha_registro = rst.getString("fecha_registro");
				String estado_aprobacion = rst.getString("estado_aprobacion");

				rendicionGastos = new RendicionGastos(rendicion_id, caja_id, categoria_id, tipo_comprobante_id,
						num_comprobante, descripcion_gasto, monto, fecha_registro, estado_aprobacion);

				rendicionesPorCajaChicaList.add(rendicionGastos);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return rendicionesPorCajaChicaList;
	}

	// método para actualizar todos los registros de rendicion de gastos por ID de
	// caja chica
	public void actualizarRegistroRendicion(int cajaId) {

		PreparedStatement pstm = null;
		String sql = "UPDATE rendicion_gastos SET estado_aprobacion = ? WHERE caja_id == ?";

		try {
			pstm = cnn.prepareStatement(sql);
			pstm.setString(1, "aprobado");
			pstm.setInt(2, cajaId);

			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, null);
		}

	}

}
