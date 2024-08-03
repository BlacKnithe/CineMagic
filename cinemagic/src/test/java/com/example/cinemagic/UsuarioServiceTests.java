package com.example.cinemagic;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.cinemagic.model.Usuario;
import com.example.cinemagic.repository.UsuarioRepository;
import com.example.cinemagic.service.UsuarioServiceImpl;

public class UsuarioServiceTests {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    // Configuración inicial
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Prueba para obtener todos los usuarios
    @Test
    public void testGetAllUsuarios() {
        usuarioService.getAllUsuarios();
        verify(usuarioRepository, times(1)).findAll();
    }

    // Prueba para obtener un usuario por ID
    @Test
    public void testGetUsuarioById() {
        Long userId = 1L;
        usuarioService.getUsuarioById(userId);
        verify(usuarioRepository, times(1)).findById(userId);
    }

    // Prueba para guardar un nuevo usuario
    @Test
    public void testSaveUsuario() {
        Usuario usuario = new Usuario();
        usuarioService.saveUsuario(usuario);
        verify(usuarioRepository, times(1)).save(usuario);
    }

    // Prueba para actualizar un usuario existente
    @Test
    public void testUpdateUsuario() {
        Long userId = 1L;
        Usuario usuarioDetails = new Usuario();
        usuarioDetails.setNombre("John");
        usuarioDetails.setApellido("Doe");
        usuarioDetails.setEmail("john.doe@example.com");
        usuarioDetails.setPassword("password");

        Usuario usuario = new Usuario();
        when(usuarioRepository.findById(userId)).thenReturn(Optional.of(usuario));

        usuarioService.updateUsuario(userId, usuarioDetails);
        verify(usuarioRepository, times(1)).save(usuario);
    }

    // Prueba para eliminar un usuario por ID
    @Test
    public void testDeleteUsuario() {
        Long userId = 1L;
        Usuario usuario = new Usuario();
        when(usuarioRepository.findById(userId)).thenReturn(Optional.of(usuario));

        usuarioService.deleteUsuario(userId);
        verify(usuarioRepository, times(1)).delete(usuario);
    }
}
