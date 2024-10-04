package com.integrity.cajachica.service;

import com.integrity.cajachica.model.Usuarios;
import com.integrity.cajachica.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepository;

	public List<Usuarios> getAllUsuarios() {
		return usuariosRepository.findAll();
	}

	public Usuarios getUsuariosById(int id) {
		return usuariosRepository.findById(id).orElse(null);
	}

	public void saveUsuarios(Usuarios usuarios) {
		usuariosRepository.save(usuarios);
	}

	public void deleteUsuarios(int id) {
		usuariosRepository.deleteById(id);
	}
}
