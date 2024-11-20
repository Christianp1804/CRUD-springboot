package com.example.demo.repositories;

import com.example.demo.models.Libro;
import com.example.demo.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByCorreoElectronico(String email);
}
