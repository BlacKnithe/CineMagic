package com.example.cinemagic.service;

import java.util.List;
import java.util.Optional;

import com.example.cinemagic.model.Usuario;

public interface UsuarioService {
     // Obtener todos los usuarios
    List<Usuario> getAllUsuarios();
    // Obtener un usuario por ID
    Optional<Usuario> getUsuarioById(Long id);
    // Guardar un nuevo usuario
    Usuario saveUsuario(Usuario usuario);
    // Actualizar un usuario existente
    Usuario updateUsuario(Long id, Usuario usuarioDetails);
    // Eliminar un usuario por ID
    boolean deleteUsuario(Long id);
}

