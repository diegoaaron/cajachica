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
        return "roles"; // Devuelve la vista productos.html
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("producto", new Rol());
        return "crear_producto"; // Formulario para crear un nuevo producto
    }

    @PostMapping
    public String createProducto(@ModelAttribute("rol") Rol rol) {
    	rolService.saveRol(rol);
        return "redirect:/roles"; // Redirige a la lista de productos
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
    public String updateProducto(@PathVariable Long id, @ModelAttribute("rol") Rol rol) {
    	rolService.saveRol(rol);
        return "redirect:/roles";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteProducto(@PathVariable int id) {
    	rolService.deleteRol(id);
        return "redirect:/roles";
    }
}
