package com.integrity.cajachica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrity.cajachica.model.CategoriaGasto;
import com.integrity.cajachica.model.RendicionGastos;
import com.integrity.cajachica.repository.CategoriaGastoRepository;
import com.integrity.cajachica.repository.RendicionGastosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaGService {
    
    @Autowired
    private RendicionGastosRepository rendicionGastosRepository;

    @Autowired
    private CategoriaGastoRepository categoriaGastoRepository;

    // Método para obtener todos los gastos
    public List<RendicionGastos> obtenerTodosLosGastos() {
        return rendicionGastosRepository.findAll();
    }

    // Método para obtener un gasto por ID
    public Optional<RendicionGastos> obtenerGastoPorId(Integer gastoId) {
        return rendicionGastosRepository.findById(gastoId);
    }

    // Método para clasificar un gasto
    public void clasificarGasto(Integer gastoId, Integer categoriaId) {
        // Buscar el gasto
        RendicionGastos gasto = rendicionGastosRepository.findById(gastoId)
            .orElseThrow(() -> new IllegalArgumentException("Gasto no encontrado"));

        // Buscar la categoría
        CategoriaGasto categoria = categoriaGastoRepository.findById(categoriaId)
            .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        // Asignar la nueva categoría al gasto
        gasto.setCategoria(categoria);

        // Guardar el cambio en la base de datos
        rendicionGastosRepository.save(gasto);
    }

    // Método para obtener todas las categorías de gasto
    public List<CategoriaGasto> obtenerTodasLasCategorias() {
        return categoriaGastoRepository.findAll();
    }
}
