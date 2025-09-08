package com.clancy.flexpod.taskapi.service;

import com.clancy.flexpod.taskapi.service.TaskService;
import com.clancy.flexpod.taskapi.model.Task;
import com.clancy.flexpod.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    TaskRepository repo;

    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public Task createTask(Task task) {
        if(task == null || !StringUtils.hasText(task.getTitle())){
            throw new IllegalArgumentException("Task title is required");
        }
        return repo.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return repo.findAll();
    }
}
