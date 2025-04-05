package com.cursomicroservice.cursomicroservice.domain.exception;

public class NoHayCursosException extends RuntimeException {
    public NoHayCursosException() {
        super("No Hay Productos En La Base De Datos.");
    }
}