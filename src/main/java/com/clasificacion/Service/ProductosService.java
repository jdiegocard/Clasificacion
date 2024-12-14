package com.clasificacion.Service;

import com.clasificacion.Entity.ProductosEntity;
import com.clasificacion.Repository.ProductosRepository;
import com.clasificacion.feign.DescripcionMinima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository repositorio;

    // Listar todos los productos
    public List<ProductosEntity> listarTodos() {
        return repositorio.findAll();
    }

    // Guardar un producto
    public ProductosEntity guardarProducto(ProductosEntity producto) {
        return repositorio.save(producto);
    }

    // Obtener un producto por su ID
    public ProductosEntity obtenerProductoPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    // Actualizar un producto por su ID
    public ProductosEntity actualizarProducto(Long id, ProductosEntity producto) {
        ProductosEntity productoExistente = obtenerProductoPorId(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setSubpartida(producto.getSubpartida());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setDescripcion(producto.getDescripcion());
        return repositorio.save(productoExistente);
    }

    // Eliminar un producto por su ID
    public void eliminarProducto(Long id) {
        repositorio.deleteById(id);
    }

    // Obtener descripciones mínimas (pendiente de implementación)
    public List<DescripcionMinima> obtenerDescripcionesMinimas(String subpartida) {
        throw new UnsupportedOperationException("Implementación pendiente.");
    }
}
