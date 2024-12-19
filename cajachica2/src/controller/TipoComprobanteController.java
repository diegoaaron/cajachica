package controller;

import java.util.ArrayList;
import model.TipoComprobante;
import model.TipoComprobanteModel;

public class TipoComprobanteController {

	public TipoComprobanteController() {

	}

	// método para listar roles para un usuario
	public ArrayList<TipoComprobante> listarTipoComprobante() {
		TipoComprobanteModel tipoComprobanteModel = new TipoComprobanteModel();
		ArrayList<TipoComprobante> listaTipoComprobante = null;

		try {
			listaTipoComprobante = tipoComprobanteModel.listarTipoComprobante();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTipoComprobante;
	}

}
