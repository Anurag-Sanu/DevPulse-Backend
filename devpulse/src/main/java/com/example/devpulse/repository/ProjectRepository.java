package com.example.devpulse.repository;

import com.example.devpulse.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // We don't need to write any code here!
    // JpaRepository gives us .save(), .findAll(), .delete() automatically.
}
