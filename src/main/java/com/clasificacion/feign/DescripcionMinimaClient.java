package com.clasificacion.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "descripcion-minima", url = "http://<URL-GATEWAY>/descripcion-minima")
public interface DescripcionMinimaClient {

    @GetMapping("/descripciones")
    List<DescripcionMinima> getDescripcionesBySubpartida(@RequestParam("subpartida") String subpartida);
}
