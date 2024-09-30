package com.integrity.cajachica.repositorio;

// 

import com.integrity.cajachica.annotation.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
