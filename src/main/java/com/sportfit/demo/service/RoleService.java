package com.sportfit.demo.service;

import com.sportfit.demo.model.Role;
import com.sportfit.demo.repository.RoleRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public Role findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null); // Devuelve null si no se encuentra el rol
    }
    
    @PostConstruct
    public void init() {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role("Admin"));
            roleRepository.save(new Role("Cliente"));
            roleRepository.save(new Role("Proveedor"));
        }
    }

}
