package com.example.devpulse.repository;

import com.example.devpulse.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task , Long> {
    // Custom method to find all tasks for a specific project
    List<Task> findByProjectId(Long projectId);
}
