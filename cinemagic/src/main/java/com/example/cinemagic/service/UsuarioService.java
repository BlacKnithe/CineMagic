package com.example.cinemagic.service;

import java.util.List;
import java.util.Optional;

import com.example.cinemagic.model.Usuario;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(Long id);
    Usuario saveUsuario(Usuario usuario);
    Usuario updateUsuario(Long id, Usuario usuarioDetails);
    boolean deleteUsuario(Long id);
}

