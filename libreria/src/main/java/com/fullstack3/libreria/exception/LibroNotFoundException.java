package com.fullstack3.libreria.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.NOT_FOUND)
public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(Long id) {
        super("Reserva no encontrada con el id: " + id);
    }
}