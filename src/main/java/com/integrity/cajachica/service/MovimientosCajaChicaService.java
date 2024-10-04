package com.integrity.cajachica.service;

import com.integrity.cajachica.model.MovimientosCajaChica;
import com.integrity.cajachica.repository.MovimientosCajaChicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientosCajaChicaService {

    @Autowired
    private MovimientosCajaChicaRepository movimientosCajaChicaRepository;

    public List<MovimientosCajaChica> getAllProductos() {
        return movimientosCajaChicaRepository.findAll();
    }

    public MovimientosCajaChica getProductoById(int id) {
        return movimientosCajaChicaRepository.findById(id).orElse(null);
    }

    public void saveProducto(MovimientosCajaChica producto) {
    	movimientosCajaChicaRepository.save(producto);
    }

    public void deleteProducto(int id) {
    	movimientosCajaChicaRepository.deleteById(id);
    }
}