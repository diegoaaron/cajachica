package controller;

import java.util.ArrayList;

import model.RendicionGastos;
import model.RendicionGastosModel;

public class RendicionGastosController {

	public RendicionGastosController() {

	}

	// método para agregar una rendicion de gasto
	public void agregarRendicion(RendicionGastos rendicionGastos) {

		RendicionGastosModel rendicionGastosModel = new RendicionGastosModel();

		try {
			rendicionGastosModel.agregarRendicion(rendicionGastos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// método para obtener rendiciones de gastos filtradas por id de caja chica
	public ArrayList<RendicionGastos> obtenerGastosPorCajaChica(int cajaId) {

		RendicionGastosModel rendicionGastosModel = new RendicionGastosModel();
		ArrayList<RendicionGastos> listaGastosPorId = null;

		try {
			listaGastosPorId = rendicionGastosModel.obtenerGastosPorCajaChica(cajaId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaGastosPorId;

	}

	// método para actualizar todos los registros de rendicion de gastos por ID de
	// caja chica
	public void actualizarRegistroRendicion(int cajaId) {

		RendicionGastosModel rendicionGastosModel = new RendicionGastosModel();
		try {
			rendicionGastosModel.actualizarRegistroRendicion(cajaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
