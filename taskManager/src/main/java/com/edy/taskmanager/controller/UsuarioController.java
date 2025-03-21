package com.edy.taskmanager.controller;

import com.edy.taskmanager.dto.UsuarioDTO;
import com.edy.taskmanager.model.Usuario;
import com.edy.taskmanager.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con los usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista con todos los usuarios registrados")
    public List<UsuarioDTO> getAll() {
        return usuarioService.getAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID", description = "Busca un usuario por su ID y lo devuelve si existe")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable UUID id) {
        Optional<Usuario> usuario = usuarioService.getById(id);
        return usuario.map(u -> ResponseEntity.ok(new UsuarioDTO(u)))
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario", description = "Guarda un nuevo usuario en la base de datos")
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(null, usuarioDTO.getNombre(), usuarioDTO.getEmail(), "", List.of());
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(new UsuarioDTO(nuevoUsuario));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario por su ID")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
