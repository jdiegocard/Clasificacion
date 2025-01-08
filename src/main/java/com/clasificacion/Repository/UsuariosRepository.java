package com.clasificacion.Repository;
import com.clasificacion.Entity.UsuariosEntity;
import org.springframework.data. jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UsuariosRepository  extends JpaRepository<UsuariosEntity, Long> {
    Optional<UsuariosEntity> findByIdentificacion(String identificacion);

}
