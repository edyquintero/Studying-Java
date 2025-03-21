package com.edy.taskmanager.controller;

import com.edy.taskmanager.dto.TareaDTO;
import com.edy.taskmanager.model.Tarea;
import com.edy.taskmanager.model.Usuario;
import com.edy.taskmanager.service.TareaService;
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
@RequestMapping("/tareas")
@Tag(name = "Tareas", description = "Operaciones relacionadas con las tareas")
public class TareaController {
    private final TareaService tareaService;
    private final UsuarioService usuarioService;

    public TareaController(TareaService tareaService, UsuarioService usuarioService) {
        this.tareaService = tareaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las tareas", description = "Devuelve una lista de todas las tareas registradas")
    public List<TareaDTO> getAll() {
        return tareaService.getAll().stream()
                .map(TareaDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarea por ID", description = "Busca una tarea por su ID y la devuelve si existe")
    public ResponseEntity<TareaDTO> getById(@PathVariable UUID id) {
        Optional<Tarea> tarea = tareaService.getById(id);
        return tarea.map(value -> ResponseEntity.ok(new TareaDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Obtener tareas por usuario", description = "Devuelve todas las tareas asignadas a un usuario específico")
    public ResponseEntity<List<TareaDTO>> getByUsuarioId(@PathVariable UUID usuarioId) {
        Optional<Usuario> usuario = usuarioService.getById(usuarioId);
        return usuario.map(value -> {
            List<TareaDTO> tareasDTO = tareaService.getByUsuario(value)
                    .stream()
                    .map(TareaDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(tareasDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear una nueva tarea", description = "Guarda una nueva tarea en la base de datos")
    public ResponseEntity<TareaDTO> save(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.save(tarea);
        return ResponseEntity.ok(new TareaDTO(nuevaTarea));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarea", description = "Elimina una tarea por su ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        tareaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
