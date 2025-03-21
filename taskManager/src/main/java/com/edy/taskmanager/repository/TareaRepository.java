package com.edy.taskmanager.repository;

import com.edy.taskmanager.model.Tarea;
import com.edy.taskmanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TareaRepository extends JpaRepository<Tarea, UUID> {
    List<Tarea> findByUsuario(Usuario usuario);
}
