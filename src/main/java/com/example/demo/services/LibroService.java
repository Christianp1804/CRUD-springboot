package com.example.demo.services;

import com.example.demo.models.Libro;
import com.example.demo.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibroByIsbn(String isbn) {
        return libroRepository.findByisbn(isbn);
    }

    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro updateLibro(String id, Libro libro) {
        if (libroRepository.existsById(id)) {
            libro.setId(id);
            return libroRepository.save(libro);
        }
        return null;
    }

    public boolean deleteLibro(String id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
