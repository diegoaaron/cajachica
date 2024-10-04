package com.integrity.cajachica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integrity.cajachica.model.CajaChica;

public interface CajaChicaRepository extends JpaRepository<CajaChica, Integer> {
    // Método para obtener todos los proyectos activos
    List<CajaChica> findAllByEstado_proyecto(boolean estado_proyecto);

    // Método para obtener un proyecto por su ID
    CajaChica findByCaja_id(Integer caja_id);
}
