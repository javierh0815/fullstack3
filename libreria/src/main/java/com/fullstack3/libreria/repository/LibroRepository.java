package com.fullstack3.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fullstack3.libreria.model.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long> {
    boolean existsByTitulo(String titulo);
    
}
