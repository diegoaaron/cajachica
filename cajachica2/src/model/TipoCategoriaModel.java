package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipoCategoriaModel {

	private Connection cnn;

	public TipoCategoriaModel() {
		this.cnn = Conexion.conectar();
	}

	// método para listar los tipos de categorias de comprobantes
	public ArrayList<TipoCategoria> listarTipoCategoria() {

		ResultSet rst = null;
		PreparedStatement pstm = null;
		TipoCategoria tipoCategoria;
		String sql = "SELECT * FROM categoria_gasto";
		ArrayList<TipoCategoria> tipoCategoriaArrayList = new ArrayList<TipoCategoria>();

		try {
			pstm = cnn.prepareStatement(sql);
			rst = pstm.executeQuery();

			if (rst.next()) {
				tipoCategoria = new TipoCategoria(rst.getInt("categoria_id"), rst.getString("nombre_categoria"));
				tipoCategoriaArrayList.add(tipoCategoria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn, null, pstm, rst);
		}

		return tipoCategoriaArrayList;
	}

}
