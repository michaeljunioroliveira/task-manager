package com.michael.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data                      // Lombok: gera getters, setters, toString automaticamente
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status = "PENDING";   // valor padrão

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}