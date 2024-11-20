package com.example.demo.services;

import com.example.demo.models.Usuario;
import com.example.demo.models.UsuarioDTO;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.utils.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioByCorreoElectronico(String email){
        return usuarioRepository.findByCorreoElectronico(email);
    }

    public UsuarioDTO createUsuario(Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(
                savedUsuario.getId(),
                savedUsuario.getNombreCompleto(),
                savedUsuario.getCorreoElectronico(),
                savedUsuario.getFechaRegistro(),
                savedUsuario.getEdad(),
                savedUsuario.getNumeroTelefono(),
                savedUsuario.getRol()
        );
    }

    public Usuario updateUsuario(String id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public boolean deleteUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
