package com.integrity.cajachica.repository;


import com.integrity.cajachica.model.MovimientosCajaChica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientosCajaChicaRepository extends JpaRepository<MovimientosCajaChica, Integer> {
}
