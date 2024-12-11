package com.clasificacion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasificacion.Entity.Productos;
import com.clasificacion.Repository.Repositorio;

import java.util.List;

@Service
public class ProductosService {
    @Autowired
    private Repositorio repositorio;

    public List<Productos> listarTodos() {
        return repositorio.findAll();
    }

    public Productos obtenerPorId(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    public Productos guardar(Productos producto) {
        return repositorio.save(producto);
    }

    public Productos actualizar(Long id, Productos producto) {
        Productos existente = obtenerPorId(id);
        existente.setNombre(producto.getNombre());
        existente.setDescripcion(producto.getDescripcion());
        existente.setCategoria(producto.getCategoria());
        existente.setPrecio(producto.getPrecio());
        return repositorio.save(existente);
    }

    public void borrar(Long id) {
        repositorio.deleteById(id);
    }
}

