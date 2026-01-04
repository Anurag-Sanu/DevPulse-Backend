package com.example.devpulse.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Task title cannot be empty") // Rule: Must have text
    @Size(min = 3, message = "Task title must be at least 3 characters") // Rule: specific length
    private String title;

    private String status; // "TODO", "IN_PROGRESS", "DONE"

    // THE IMPORTANT PART: Connecting to Project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    @JsonIgnore // Prevents infinite loops when converting to JSON
    private Project project;
}