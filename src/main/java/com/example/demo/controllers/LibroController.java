package com.example.demo.controllers;

import com.example.demo.models.Libro;
import com.example.demo.services.LibroService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.getAllLibros();
        return libros.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(libros);
    }


    @GetMapping("/{isbn}")
    public ResponseEntity<Libro> findByIsbn(@PathVariable String isbn) {
        Optional<Libro> libro = libroService.getLibroByIsbn(isbn);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping
    public ResponseEntity<?> createLibro(@Valid @RequestBody Libro libro, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .toList();

            throw new ValidationException(String.valueOf(errorMessages));
        }

        Libro savedLibro = libroService.createLibro(libro);
        return new ResponseEntity<>(savedLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable String id, @RequestBody Libro libro) {
        Libro updatedLibro = libroService.updateLibro(id, libro);
        return updatedLibro != null
                ? ResponseEntity.ok(updatedLibro)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable String id) {
        boolean isDeleted = libroService.deleteLibro(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
