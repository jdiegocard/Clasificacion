package com.clasificacion.feign;

import jakarta.persistence.*;

@Entity
@Table(name = "descripcion_minima")
public class DescripcionMinima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uso;
    private String destino;
    private String serial;
    private String subpartida;

    // Constructor vacío
    public DescripcionMinima() {}

    // Constructor con parámetros
    public DescripcionMinima(String uso, String destino, String serial, String subpartida) {
        this.uso = uso;
        this.destino = destino;
        this.serial = serial;
        this.subpartida = subpartida;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSubpartida() {
        return subpartida;
    }

    public void setSubpartida(String subpartida) {
        this.subpartida = subpartida;
    }
}
