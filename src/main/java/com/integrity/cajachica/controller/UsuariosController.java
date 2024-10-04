package com.integrity.cajachica.controller;

import com.integrity.cajachica.model.Usuarios;
import com.integrity.cajachica.service.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public String getAllUsurios(Model model) {
        model.addAttribute("usuarios", usuariosService.getAllUsuarios());
        return "usuarios"; // Devuelve la vista usuarios.html
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("usuarios", new Usuarios());
        return "crear_usuarios"; // Formulario para crear un nuevo producto
    }

    @PostMapping
    public String createUsuarios(@ModelAttribute("usuarios") Usuarios usuarios) {
    	usuariosService.saveUsuarios(usuarios);
        return "redirect:/usuarios"; // Redirige a la lista de productos
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
    	Usuarios usuarios = usuariosService.getUsuariosById(id);
        if (usuarios != null) {
            model.addAttribute("usuarios", usuarios);
            return "editar_usuarios"; // Formulario para editar producto
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/actualizar/{id}")
    public String updateUsuarios(@PathVariable Long id, @ModelAttribute("usuarios") Usuarios usuarios) {
    	usuariosService.saveUsuarios(usuarios);
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteUsuarios(@PathVariable int id) {
    	usuariosService.deleteUsuarios(id);
        return "redirect:/usuarios";
    }
}
