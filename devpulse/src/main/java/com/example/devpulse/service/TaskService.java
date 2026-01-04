package com.example.devpulse.service;

import com.example.devpulse.entity.Project;
import com.example.devpulse.entity.Task;
import com.example.devpulse.repository.ProjectRepository;
import com.example.devpulse.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service // Tells Spring: "This class holds the BUSINESS LOGIC"
    public class TaskService {

        @Autowired
        private TaskRepository taskRepository;

        @Autowired
        private ProjectRepository projectRepository;

        public Task createTask(Long projectId, Task task) {
            // LOGIC: Check if project exists
            Project project = projectRepository.findById(projectId)
                    .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));

            // LOGIC: Link task to project
            task.setProject(project);

            // LOGIC: Default status if missing
            if (task.getStatus() == null) {
                task.setStatus("TODO");
            }

            return taskRepository.save(task);
        }

        public List<Task> getTasksByProject(Long projectId) {
            return taskRepository.findByProjectId(projectId);
        }

        // 3. Update Logic
        public Task updateTask(Long taskId, Task taskDetails) {
            // Step 1: Find the task or throw error
            Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));

            // Step 2: Apply the updates
            task.setTitle(taskDetails.getTitle());
            task.setStatus(taskDetails.getStatus());

            // Step 3: Save and return
            return taskRepository.save(task);
        }

        // 4. Delete Logic
        public void deleteTask(Long taskId) {
            // Step 1: Find the task (good practice to check existence before delete)
            Task task = taskRepository.findById(taskId)
                    .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));

            // Step 2: Delete
            taskRepository.delete(task);
        }
    }
