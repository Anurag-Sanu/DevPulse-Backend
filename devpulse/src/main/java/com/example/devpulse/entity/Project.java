package com.example.devpulse.entity;

import jakarta.persistence.*; // This imports @Entity, @Id, @GeneratedValue
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "projects")
public class Project {

    @Id // <--- This was missing or not imported correctly!
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private LocalDate startDate;
}
