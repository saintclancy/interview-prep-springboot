package com.clancy.flexpod.taskapi.controller;

import com.clancy.flexpod.taskapi.dto.TaskDTO;
import com.clancy.flexpod.taskapi.service.TaskService;
import com.clancy.flexpod.taskapi.model.Task;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        Task toSave = new Task(taskDTO.getTitle(), taskDTO.getCompleted() != null && taskDTO.getCompleted());
        Task saved = taskService.createTask(toSave);
        return ResponseEntity.ok().body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
    return taskService.getTaskById(id)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found"));
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
//    controller/TaskController
//- @RestController, @RequestMapping("/tasks"), @PostMapping, @GetMapping
//- import TaskDTO, Task, TaskService, Validation
//- class variables: TaskService service
//- Constructor
//- POST ResponseEntity<Task> createTask(@Valid @RequestBody TaskDTO dto)
//- GET, ResponseEntity<Task> getTask(@PathVariable Long id)
//- GET, List<Task> getAll()
