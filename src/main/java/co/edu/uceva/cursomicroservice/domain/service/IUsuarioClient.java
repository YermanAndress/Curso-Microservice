package co.edu.uceva.cursomicroservice.domain.service;

import co.edu.uceva.cursomicroservice.domain.model.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "usuarioservice")
public interface IUsuarioClient {
    @GetMapping("api/v1/usuario-service/usuarios/docentes")
    Map<String, List<UsuarioDTO>> idDocente();
}