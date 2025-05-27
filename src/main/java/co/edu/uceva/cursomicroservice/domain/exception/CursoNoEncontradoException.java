package co.edu.uceva.cursomicroservice.domain.exception;

public class CursoNoEncontradoException extends RuntimeException {
    public CursoNoEncontradoException(Long id) {
        super("El Curso Con ID " + id + " No Fue Encontrado.");
    }
}