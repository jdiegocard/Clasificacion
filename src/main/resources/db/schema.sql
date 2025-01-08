-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS clasificacion DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
USE clasificacion;

-- Crear tabla productos
CREATE TABLE IF NOT EXISTS productos (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         nombre VARCHAR(255) NOT NULL UNIQUE
    ) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Crear tabla usuarios
CREATE TABLE IF NOT EXISTS usuarios (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        identificacion VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
    ) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
