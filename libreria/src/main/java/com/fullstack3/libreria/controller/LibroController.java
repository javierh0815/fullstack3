package com.fullstack3.libreria.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid; 
import java.util.List;

import com.fullstack3.libreria.model.Libro;
import com.fullstack3.libreria.service.LibroService;


@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.getAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Libro libro = libroService.getLibroById(id);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Libro> createLibro(@Valid @RequestBody Libro libro) {
        Libro createdLibro = libroService.createLibro(libro);
        return new ResponseEntity<>(createdLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @Valid @RequestBody Libro libro) {
        Libro updatedLibro = libroService.updateLibro(id, libro);
        if (updatedLibro != null) {
            return new ResponseEntity<>(updatedLibro, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}