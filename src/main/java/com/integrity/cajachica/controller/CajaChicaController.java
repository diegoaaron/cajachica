package com.integrity.cajachica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.integrity.cajachica.service.CajaChicaService;

@Controller
public class CajaChicaController {

    @Autowired
    private CajaChicaService cajaChicaService;

    // Método que maneja la solicitud de verificación de saldo
    @GetMapping("/verificar_saldo")
    public String mostrarFormularioVerificarSaldo(Model model) {
        // Agrega todos los proyectos activos al modelo
        model.addAttribute("proyectos", cajaChicaService.obtenerProyectosActivos());
        return "verificar_saldo"; 
    }
}
