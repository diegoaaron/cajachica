package controller;

import java.util.ArrayList;

import model.CajaChica;
import model.CajaChicaModel;

public class CajaChicaController {

	public CajaChicaController() {

	}

	// método para agregar una caja chica
	public void agregarCaja(int usuario_id, String nombre_proyecto, String descripcion, double monto_asignado,
			double monto_gastado, double monto_cierre, String fecha_apertura, String fecha_cierre,
			String estado_proyecto) {
		CajaChicaModel cajaChicaModel = new CajaChicaModel();
		CajaChica cajaChica = new CajaChica(usuario_id, nombre_proyecto, descripcion, monto_asignado, monto_gastado,
				monto_cierre, fecha_apertura, fecha_cierre, estado_proyecto);

		try {
			cajaChicaModel.agregarCaja(cajaChica);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// método para listar caja chica activa por id de usuario
	public CajaChica listarCajasPorUsuario(int usuario_id) {
		CajaChicaModel cajaChicaModel = new CajaChicaModel();
		CajaChica cajaChica = null;
		try {
			cajaChica = cajaChicaModel.listarCajasPorUsuario(usuario_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cajaChica;
	}

	// método para listar todas las cajas abiertas
	public ArrayList<CajaChica> listarCajasAbiertas() {
		CajaChicaModel cajaChicaModel = new CajaChicaModel();
		ArrayList<CajaChica> listaCajasChicasAbiertas = null;

		try {
			listaCajasChicasAbiertas = cajaChicaModel.listarCajasAbiertas();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaCajasChicasAbiertas;
	}

	// método para aprobar una caja chica
	public void aprobarCajaChica(int caja_id) {
		CajaChicaModel cajaChicaModel = new CajaChicaModel();

		try {
			cajaChicaModel.aprobarCajaChica(caja_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
