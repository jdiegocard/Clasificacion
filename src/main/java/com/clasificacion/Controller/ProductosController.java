package com.clasificacion.Controller;

import com.clasificacion.Entity.ProductosEntity;
import com.clasificacion.Service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    // Obtener todos los productos
    @GetMapping
    public List<ProductosEntity> getAllProductos() {
        return productosService.listarTodos(); // Método corregido
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ProductosEntity getProductoById(@PathVariable Long id) {
        return productosService.obtenerProductoPorId(id); // Método corregido
    }

    // Crear un nuevo producto
    @PostMapping
    public ProductosEntity createProducto(@RequestBody ProductosEntity producto) {
        return productosService.guardarProducto(producto); // Método corregido
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ProductosEntity updateProducto(@PathVariable Long id, @RequestBody ProductosEntity producto) {
        return productosService.actualizarProducto(id, producto); // Método existente
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productosService.eliminarProducto(id); // Método corregido
    }
}
