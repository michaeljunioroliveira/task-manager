package com.michael.taskmanager.service;

import com.michael.taskmanager.model.Task;
import com.michael.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Spring injeta o repository automaticamente (injeção de dependência)
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // CREATE
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    // READ ALL
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // READ ONE
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada: " + id));
    }

    // UPDATE
    public Task update(Long id, Task taskAtualizada) {
        Task task = findById(id);
        task.setTitle(taskAtualizada.getTitle());
        task.setDescription(taskAtualizada.getDescription());
        task.setStatus(taskAtualizada.getStatus());
        return taskRepository.save(task);
    }

    // DELETE
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}