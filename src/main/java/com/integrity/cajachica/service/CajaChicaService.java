package com.integrity.cajachica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrity.cajachica.model.CajaChica;
import com.integrity.cajachica.repository.CajaChicaRepository;

@Service
public class CajaChicaService {
    
    @Autowired
    private CajaChicaRepository cajaChicaRepository;

    // Método para obtener todos los proyectos activos
    public List<CajaChica> obtenerProyectosActivos() {
        return cajaChicaRepository.findAllByEstado_proyecto(true);
    }

    // Método para obtener un proyecto por su ID
    public CajaChica obtenerProyectoPorId(Integer cajaId) {
        return cajaChicaRepository.findByCaja_id(cajaId);
    }
}
