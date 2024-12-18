package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipoComprobanteModel {

	private Connection cnn;

	public TipoComprobanteModel() {
		this.cnn = Conexion.conectar();
	}

	// método para listar roles para un usuario
	public ArrayList<TipoComprobante> listarTipoComprobante() {

		ResultSet rst = null;
		PreparedStatement pstm = null;
		TipoComprobante tipoComprobante;
		String sql = "SELECT * FROM tipo_comprobante";
		ArrayList<TipoComprobante> rolUsuarioArrayList = new ArrayList<TipoComprobante>();

		try {
			pstm = cnn.prepareStatement(sql);
			rst = pstm.executeQuery();

			if (rst.next()) {
				tipoComprobante = new TipoComprobante(rst.getInt("tipo_comprobante_id"),
						rst.getString("nombre_tipo_comprobante"));
				rolUsuarioArrayList.add(tipoComprobante);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return rolUsuarioArrayList;
	}

}
