-- Crear tabla de roles
CREATE TABLE IF NOT EXISTS roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Crear tabla de usuarios
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id BIGINT,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Insertar roles
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'CLIENTE');
INSERT INTO roles (id, name) VALUES (3, 'PROVEEDOR');

-- Insertar usuarios
INSERT INTO users (id, nombre, email, password, role_id) VALUES (1, 'Admin', 'admin@example.com', 'password', 1);
INSERT INTO users (id, nombre, email, password, role_id) VALUES (2, 'Cliente', 'cliente@example.com', 'password', 2);
INSERT INTO users (id, nombre, email, password, role_id) VALUES (3, 'Proveedor', 'proveedor@example.com', 'password', 3);
