package com.integrity.cajachica.controller;

import com.integrity.cajachica.annotation.Producto;
import com.integrity.cajachica.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable int id) {
    	Producto producto = productoService.obtenerPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto productoExistente = productoService.obtenerPorId(id);
        if (productoExistente != null) {
            producto.setId(id);
            return ResponseEntity.ok(productoService.guardar(producto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        if (productoService.obtenerPorId(id) != null) {
            productoService.eliminar(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
