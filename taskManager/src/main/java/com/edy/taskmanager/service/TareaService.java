package com.edy.taskmanager.service;

import com.edy.taskmanager.model.Tarea;
import com.edy.taskmanager.model.Usuario;
import com.edy.taskmanager.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TareaService {

    private TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> getAll() {
        return tareaRepository.findAll();
    }

    public List<Tarea> getByUsuario(Usuario usuario) {
        return tareaRepository.findByUsuario(usuario);
    }

    public Optional<Tarea> getById(UUID id) {
        return tareaRepository.findById(id);
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void delete(UUID id) {
        tareaRepository.deleteById(id);
    }
}
