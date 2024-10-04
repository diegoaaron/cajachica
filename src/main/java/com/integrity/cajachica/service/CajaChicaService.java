package com.integrity.cajachica.service;

import com.integrity.cajachica.model.CajaChica;
import com.integrity.cajachica.repository.CajaChicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajaChicaService {

    @Autowired
    private CajaChicaRepository cajaChicaRepository;

    public List<CajaChica> getAllProductos() {
        return cajaChicaRepository.findAll();
    }

    public CajaChica getProductoById(int id) {
        return cajaChicaRepository.findById(id).orElse(null);
    }

    public void saveProducto(CajaChica cajachica) {
    	cajaChicaRepository.save(cajachica);
    }

    public void deleteProducto(int id) {
    	cajaChicaRepository.deleteById(id);
    }
}