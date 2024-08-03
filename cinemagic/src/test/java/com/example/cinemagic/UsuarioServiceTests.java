package com.example.cinemagic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import com.example.cinemagic.repository.UsuarioRepository;
import com.example.cinemagic.service.UsuarioService;

public class UsuarioServiceTests {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

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

    
}
