package com.clasificacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.clasificacion.Entity.Productos;
import com.clasificacion.Service.ProductosService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class Controlador {
    @Autowired
    private ProductosService productosService;

    @GetMapping
    public List<Productos> listarTodos() {
        return productosService.listarTodos();
    }

    @GetMapping("/{id}")
    public Productos obtenerPorId(@PathVariable Long id) {
        return productosService.obtenerPorId(id);
    }

    @PostMapping
    public Productos guardar(@RequestBody Productos producto) {
        return productosService.guardar(producto);
    }

    @PutMapping("/{id}")
    public Productos actualizar(@PathVariable Long id, @RequestBody Productos producto) {
        return productosService.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        productosService.borrar(id);
    }
}
