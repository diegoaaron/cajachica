package controller;

import java.util.ArrayList;

import model.RolUsuario;
import model.RolUsuarioModel;

public class RolUsuarioController {

	public RolUsuarioController() {

	}

	// método para listar roles para un usuario
	public ArrayList<RolUsuario> listarRolesUsuario() {

		RolUsuarioModel rolUsuarioModel = new RolUsuarioModel();
		ArrayList<RolUsuario> listaRolesUsuario = null;

		try {
			listaRolesUsuario = rolUsuarioModel.listarRolesUsuario();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRolesUsuario;
	}
}
