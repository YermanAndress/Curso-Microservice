package co.edu.uceva.cursomicroservice.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CursoNoEncontradoException extends RuntimeException {
    public CursoNoEncontradoException(Long id) {
        super("El Curso Con ID " + id + " No Fue Encontrado.");
    }
}