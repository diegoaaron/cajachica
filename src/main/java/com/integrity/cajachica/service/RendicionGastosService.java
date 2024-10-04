package com.integrity.cajachica.service;

import com.integrity.cajachica.model.RendicionGastos;
import com.integrity.cajachica.repository.RendicionGastosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendicionGastosService {

    @Autowired
    private RendicionGastosRepository rendicionGastosRepository;

    public List<RendicionGastos> getAllProductos() {
        return rendicionGastosRepository.findAll();
    }

    public RendicionGastos getProductoById(int id) {
        return rendicionGastosRepository.findById(id).orElse(null);
    }

    public void saveProducto(RendicionGastos rendiciongastos) {
    	rendicionGastosRepository.save(rendiciongastos);
    }

    public void deleteProducto(int id) {
    	rendicionGastosRepository.deleteById(id);
    }
}