package com.integrity.cajachica.controller;

import com.integrity.cajachica.model.Producto;
import com.integrity.cajachica.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String getAllProductos(Model model) {
        model.addAttribute("productos", productoService.getAllProductos());
        return "productos"; // Devuelve la vista productos.html
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "crear_producto"; // Formulario para crear un nuevo producto
    }

    @PostMapping
    public String createProducto(@ModelAttribute("producto") Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/productos"; // Redirige a la lista de productos
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Producto producto = productoService.getProductoById(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "editar_producto"; // Formulario para editar producto
        }
        return "redirect:/productos";
    }

    @PostMapping("/actualizar/{id}")
    public String updateProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
        return "redirect:/productos";
    }
}
