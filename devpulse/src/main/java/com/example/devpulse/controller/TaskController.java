package com.example.devpulse.controller;

import com.example.devpulse.entity.Task;
import com.example.devpulse.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class TaskController {

    @Autowired
    private TaskService taskService; // We now talk to SERVICE, not Repository

    // 1. Create Task
    @PostMapping("/{projectId}/tasks")
    public Task createTask(@PathVariable Long projectId, @Valid @RequestBody Task task) {
        // The @Valid annotation triggers the "Bouncer" before this code even runs!
        return taskService.createTask(projectId, task);
    }

    // 2. Get Tasks
    @GetMapping("/{projectId}/tasks")
    public List<Task> getTasksByProject(@PathVariable Long projectId) {
        return taskService.getTasksByProject(projectId);
    }

    // 3. Update Task
    @PutMapping("/tasks/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task taskDetails) {
        return taskService.updateTask(taskId, taskDetails);
    }

    // 4. Delete Task
    @DeleteMapping("/tasks/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return "Task " + taskId + " deleted successfully";
    }
}
