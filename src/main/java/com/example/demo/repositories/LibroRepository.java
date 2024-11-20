package com.example.demo.repositories;

import com.example.demo.models.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface LibroRepository extends MongoRepository<Libro, String> {
    Optional<Libro> findByisbn(String isbn);
}
