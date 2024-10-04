package com.integrity.cajachica.service;

import com.integrity.cajachica.model.TipoComprobante;
import com.integrity.cajachica.repository.TipoComprobanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoComprobanteService {

    @Autowired
    private TipoComprobanteRepository tipoComprobanteRepository;

    public List<TipoComprobante> getAllProductos() {
        return tipoComprobanteRepository.findAll();
    }

    public TipoComprobante getProductoById(int id) {
        return tipoComprobanteRepository.findById(id).orElse(null);
    }

    public void saveProducto(TipoComprobante tipocomprobante) {
    	tipoComprobanteRepository.save(tipocomprobante);
    }

    public void deleteProducto(int id) {
    	tipoComprobanteRepository.deleteById(id);
    }
}