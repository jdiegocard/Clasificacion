package com.clasificacion.Service;

import com.clasificacion.Entity.ProductosEntity;
import com.clasificacion.Repository.ProductosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productos {

    @Autowired
    private ProductosRepository productosRepositorio;

    // Obtener todos los productos
    public List<ProductosEntity> getAllProductos() {
        return productosRepositorio.findAll();
    }

    // Obtener un producto por ID
    public ProductosEntity getProductoById(Long id) {
        return productosRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    // Crear un nuevo producto
    public ProductosEntity createProducto(ProductosEntity producto) {
        return productosRepositorio.save(producto);
    }

    // Actualizar un producto existente
    public ProductosEntity updateProducto(Long id, ProductosEntity producto) {
        ProductosEntity productoExistente = getProductoById(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setSubpartida(producto.getSubpartida());
        return productosRepositorio.save(productoExistente);
    }

    // Eliminar un producto
    public void deleteProducto(Long id) {
        productosRepositorio.deleteById(id);
    }
}
