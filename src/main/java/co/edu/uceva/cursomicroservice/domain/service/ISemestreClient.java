package co.edu.uceva.cursomicroservice.domain.service;

import co.edu.uceva.cursomicroservice.domain.model.SemestreDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "semestreservice")
public interface ISemestreClient {
    @GetMapping("api/v1/semestre-service/semestres")
    Map<String, List<SemestreDTO>> idSemestre();
}