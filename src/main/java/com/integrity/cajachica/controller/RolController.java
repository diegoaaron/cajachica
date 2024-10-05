package com.integrity.cajachica.controller;

import com.integrity.cajachica.model.Rol;
import com.integrity.cajachica.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private RolService rolService;

	@GetMapping
	public String getAllRoles(Model model) {
		model.addAttribute("roles", rolService.getAllRoles());
		return "roles"; // Devuelve la vista roles.html
	}

	@GetMapping("/nuevo")
	public String showCreateForm(Model model) {
		model.addAttribute("rol", new Rol());
		return "crear_rol"; // Formulario para crear un nuevo rold
	}

	@PostMapping
	public String createRol(@ModelAttribute("rol") Rol rol, Model model) {
		try {
			rolService.saveRol(rol);
			return "redirect:/roles"; // Redirige a la lista de roles
		} catch (IllegalArgumentException e) {
			model.addAttribute("error", e.getMessage());
			return "crear_rol";
		}
	}

	@GetMapping("/editar/{id}")
	public String showEditForm(@PathVariable int id, Model model) {
		Rol rol = rolService.getRolById(id);
		if (rol != null) {
			model.addAttribute("rol", rol);
			return "editar_rol"; // Formulario para editar producto
		}
		return "redirect:/roles";
	}

	@PostMapping("/actualizar/{id}")
	public String updateRol(@PathVariable int id, @ModelAttribute("rol") Rol rol, Model model) {

		Rol rolExistente = rolService.getRolById(id);

		// Modificar las propiedades del rol existente, excepto la colección de usuarios
		rolExistente.setNombrerol(rol.getNombrerol());
		rolExistente.setDescripcion(rol.getDescripcion());
		rolExistente.setFecha_creacion(rol.getFecha_creacion());

		rolService.updateRol(rolExistente);
		return "redirect:/roles"; // Redirige a la lista de roles

	}

	@GetMapping("/eliminar/{id}")
	public String deleteRol(@PathVariable int id) {
		rolService.deleteRol(id);
		return "redirect:/roles";
	}
}
