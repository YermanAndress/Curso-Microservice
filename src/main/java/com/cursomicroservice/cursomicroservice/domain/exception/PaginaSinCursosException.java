package com.cursomicroservice.cursomicroservice.domain.exception;

public class PaginaSinCursosException extends RuntimeException {
    public PaginaSinCursosException(int page) {
        super("No Hay Cursos En La Pagina Solicitada: " + page);
    }
}