package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import com.example.demo.models.UsuarioDTO;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.getUsuarioByCorreoElectronico(email);
        Usuario usuarioDTO = new Usuario();
        usuarioDTO.setId(usuario.get().getId());
        usuarioDTO.setNombreCompleto(usuario.get().getNombreCompleto());
        usuarioDTO.setCorreoElectronico(usuario.get().getCorreoElectronico());
        usuarioDTO.setRol(usuario.get().getRol());

        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody Usuario usuario) {
        // Create the user (password is already encoded in service)
        UsuarioDTO createdUsuarioDTO = usuarioService.createUsuario(usuario);

        // Return 201 Created with the created user DTO in the response body
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario) != null
                ? ResponseEntity.ok(usuario)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
        return usuarioService.deleteUsuario(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
