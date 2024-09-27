package com.sportfit.demo;

import com.sportfit.demo.model.Role;
import com.sportfit.demo.model.User;
import com.sportfit.demo.repository.RoleRepository;
import com.sportfit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear roles
        Role adminRole = new Role("ADMIN");
        Role clienteRole = new Role("CLIENTE");
        Role proveedorRole = new Role("PROVEEDOR");

        roleRepository.save(adminRole);
        roleRepository.save(clienteRole);
        roleRepository.save(proveedorRole);

        // Crear usuarios
        User adminUser = new User("Admin", "admin@example.com", "admin123", adminRole);
        User clienteUser = new User("Cliente", "cliente@example.com", "cliente123", clienteRole);
        User proveedorUser = new User("Proveedor", "proveedor@example.com", "proveedor123", proveedorRole);

        userRepository.save(adminUser);
        userRepository.save(clienteUser);
        userRepository.save(proveedorUser);
    }
}
