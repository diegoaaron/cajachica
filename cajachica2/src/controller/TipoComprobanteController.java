package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.TipoComprobante;

public class TipoComprobanteController {

	private final Connection cnn3;
	private ArrayList<TipoComprobante> tipoComprobanteArrayList;

	public TipoComprobanteController(Connection cnn3) {
		this.cnn3 = cnn3;
	}

	public ArrayList<TipoComprobante> listaTipoComprobante() {
		Statement st3 = null;
		ResultSet rs3 = null;
		TipoComprobante tipoComprobanteModel;
		tipoComprobanteArrayList = new ArrayList<>();

		try {
			String sql = "select * from Tipo_Comprobante";
			st3 = cnn3.createStatement();
			rs3 = st3.executeQuery(sql);

			while (rs3.next()) {
				int tipo_comprobante_id = rs3.getInt("tipo_comprobante_id");
				String nombre_tipo_comprobante = rs3.getString("nombre_tipo_comprobante");
				tipoComprobanteModel = new TipoComprobante(tipo_comprobante_id, nombre_tipo_comprobante);
				tipoComprobanteArrayList.add(tipoComprobanteModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(st3, rs3);
		}

		return tipoComprobanteArrayList;
	}

}
