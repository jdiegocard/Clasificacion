package com.clasificacion.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.clasificacion.Entity.Productos;

import java.util.List;

public interface Repositorio extends JpaRepository<Productos, Long> {
    List<Productos> findByNombreContaining(String nombre);
}

