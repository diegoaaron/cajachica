package com.integrity.cajachica.service;

import com.integrity.cajachica.model.Rol;
import com.integrity.cajachica.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    public Rol getRolById(int id) {
        return rolRepository.findById(id).orElse(null);
    }

    public void saveRol(Rol rol) {
    	rolRepository.save(rol);
    }

    public void deleteRol(int id) {
    	rolRepository.deleteById(id);
    }
}