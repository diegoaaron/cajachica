package com.integrity.cajachica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrity.cajachica.model.CategoriaGasto;
import com.integrity.cajachica.model.RendicionGastos;
import com.integrity.cajachica.repository.CategoriaGastoRepository;
import com.integrity.cajachica.repository.RendicionGastosRepository;
import java.util.List;
@Service
public class RendicionGService {
    
    @Autowired
    private RendicionGastosRepository rendicionGastosRepository;

    @Autowired
    private CategoriaGastoRepository categoriaGastoRepository;

    // Método para obtener todos los gastos
    public List<RendicionGastos> obtenerTodosLosGastos() {
        return rendicionGastosRepository.findAll();
    }

    // Método para clasificar un gasto
    public void clasificarGasto(Integer gastoId, Integer categoriaId) {
        RendicionGastos gasto = rendicionGastosRepository.findById(gastoId)
            .orElseThrow(() -> new IllegalArgumentException("Gasto no encontrado"));
        
        CategoriaGasto categoria = categoriaGastoRepository.findById(categoriaId)
            .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        gasto.setCategoria(categoria);
        rendicionGastosRepository.save(gasto);
    }
}
