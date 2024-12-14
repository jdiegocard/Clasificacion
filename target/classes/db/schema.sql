-- schema.sql
CREATE DATABASE IF NOT EXISTS clasificacion DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
USE clasificacion;

-- Asegurarnos de que estamos en el esquema correcto
CREATE SCHEMA IF NOT EXISTS clasificacion;
USE clasificacion;

-- Crear tabla productos
CREATE TABLE IF NOT EXISTS productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE 
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;