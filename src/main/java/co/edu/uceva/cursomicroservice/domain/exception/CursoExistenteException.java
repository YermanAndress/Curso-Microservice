package co.edu.uceva.cursomicroservice.domain.exception;

public class CursoExistenteException extends RuntimeException {
    public CursoExistenteException(String nombre) {
        super("El Curso Con Nombre '" + nombre + "' Ya Existe.");
    }
}
