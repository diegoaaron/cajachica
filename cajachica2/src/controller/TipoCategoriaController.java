package controller;

import java.util.ArrayList;

import model.TipoCategoria;
import model.TipoCategoriaModel;

public class TipoCategoriaController {

	public TipoCategoriaController() {

	}

	// método para listar los tipos de categorias de comprobantes
	public ArrayList<TipoCategoria> listarTipoCategoria() {
		TipoCategoriaModel tipoCategoriaModel = new TipoCategoriaModel();
		ArrayList<TipoCategoria> listaCategorias = null;

		try {
			listaCategorias = tipoCategoriaModel.listarTipoCategoria();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaCategorias;
	}
}
