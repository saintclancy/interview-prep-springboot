package com.clancy.flexpod.taskapi.service;

import com.clancy.flexpod.taskapi.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
    //TODO: CRUD methods can be added as needed
}
