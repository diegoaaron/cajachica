package com.integrity.cajachica.service;

import com.integrity.cajachica.model.CategoriaGasto;
import com.integrity.cajachica.repository.CategoriaGastoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaGastoService {

    @Autowired
    private CategoriaGastoRepository categoriaGastoRepository;

    public List<CategoriaGasto> getAllProductos() {
        return categoriaGastoRepository.findAll();
    }

    public CategoriaGasto getProductoById(int id) {
        return categoriaGastoRepository.findById(id).orElse(null);
    }

    public void saveProducto(CategoriaGasto categoriagasto) {
    	categoriaGastoRepository.save(categoriagasto);
    }

    public void deleteProducto(int id) {
    	categoriaGastoRepository.deleteById(id);
    }
}