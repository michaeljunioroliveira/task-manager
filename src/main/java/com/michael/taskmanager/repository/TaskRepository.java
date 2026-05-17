package com.michael.taskmanager.repository;

import com.michael.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Só isso! O Spring Data gera todo o CRUD automaticamente
}