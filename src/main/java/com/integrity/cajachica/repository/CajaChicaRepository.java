package com.integrity.cajachica.repository;

import com.integrity.cajachica.model.CajaChica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaChicaRepository extends JpaRepository<CajaChica, Integer> {
}
