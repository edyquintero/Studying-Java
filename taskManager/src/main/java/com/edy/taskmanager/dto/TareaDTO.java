package com.edy.taskmanager.dto;

import com.edy.taskmanager.model.EstadoTarea;
import com.edy.taskmanager.model.Tarea;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
public class TareaDTO {
    private UUID id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fecha_vencimiento;
    private EstadoTarea estado;
    private UsuarioDTO usuario;

    public TareaDTO() {}

    public TareaDTO(Tarea tarea) {
        this.id = tarea.getId();
        this.titulo = tarea.getTitulo();
        this.descripcion = tarea.getDescripcion();
        this.fecha_vencimiento = tarea.getFecha_vencimiento();
        this.estado = tarea.getEstado();
        this.usuario = tarea.getUsuario() != null ? new UsuarioDTO(tarea.getUsuario()) : null;
    }
}
