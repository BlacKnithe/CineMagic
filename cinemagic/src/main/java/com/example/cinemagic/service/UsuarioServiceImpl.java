package com.example.cinemagic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinemagic.model.Usuario;
import com.example.cinemagic.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    @Override
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guardar un nuevo usuario
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario existente
    @Override
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setApellido(usuarioDetails.getApellido());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setPassword(usuarioDetails.getPassword());
            return usuarioRepository.save(usuario);
        }).orElseGet(() -> {
            usuarioDetails.setId(id);
            return usuarioRepository.save(usuarioDetails);
        });
    }

    // Eliminar un usuario por ID
    @Override
    public boolean deleteUsuario(Long id) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuarioRepository.delete(usuario);
            return true;
        }).orElse(false);
    }
}
