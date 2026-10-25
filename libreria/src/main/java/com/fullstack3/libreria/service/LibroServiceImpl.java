package com.fullstack3.libreria.service;




import org.springframework.stereotype.Service;
import java.util.List;
import com.fullstack3.libreria.model.Libro;
import com.fullstack3.libreria.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro updateLibro(Long id, Libro libro) {
        Libro existingLibro = libroRepository.findById(id).orElse(null);
        if (existingLibro != null) {
            existingLibro.setTitulo(libro.getTitulo());
            existingLibro.setAutor(libro.getAutor());
            existingLibro.setAnioPub(libro.getAnioPub());
            existingLibro.setGenero(libro.getGenero());
            return libroRepository.save(existingLibro);
        }
        return null;
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }
    
}
