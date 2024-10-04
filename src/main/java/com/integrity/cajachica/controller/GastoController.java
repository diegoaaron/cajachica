package com.integrity.cajachica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.integrity.cajachica.service.CategoriaGService;  // Servicio para manejar las categorías
import com.integrity.cajachica.service.RendicionGService;

@Controller
public class GastoController {

    @Autowired
    private RendicionGService rendicionGastosService;

    @Autowired
    private CategoriaGService categoriaGService;

    @GetMapping("/clasificar-gasto")
    public String mostrarFormularioClasificar(Model model) {
        // Obtener todos los gastos y categorías a través de los servicios
        model.addAttribute("gastos", rendicionGastosService.obtenerTodosLosGastos());
        model.addAttribute("categorias", categoriaGService.obtenerTodasLasCategorias());

        return "gastosCategoria/clasificarGasto";  // Asegúrate de especificar la subcarpeta correcta
    }

    @PostMapping("/api/gastos/clasificar")
    public String clasificarGasto(@RequestParam Integer gastoId, @RequestParam Integer categoriaId) {
        // Clasificar el gasto usando los servicios
        rendicionGastosService.clasificarGasto(gastoId, categoriaId);

        return "redirect:/clasificar-gasto";
    }
    
}
