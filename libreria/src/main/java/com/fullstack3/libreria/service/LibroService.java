package com.fullstack3.libreria.service;

import com.fullstack3.libreria.model.Libro;
import java.util.List;


public interface LibroService {

    List<Libro> getAllLibros();
    Libro getLibroById(Long id);
    Libro createLibro(Libro libro);
    Libro updateLibro(Long id, Libro libro);
    void deleteLibro(Long id);
    
}
