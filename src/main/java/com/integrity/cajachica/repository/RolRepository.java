package com.integrity.cajachica.repository;

import com.integrity.cajachica.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	boolean existsByNombrerol(String nombrerol); // Método para verificar si el nombre ya existe
}
