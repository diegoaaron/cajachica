package com.integrity.cajachica.repository;

import com.integrity.cajachica.model.RendicionGastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendicionGastosRepository extends JpaRepository<RendicionGastos, Integer> {
   
}
