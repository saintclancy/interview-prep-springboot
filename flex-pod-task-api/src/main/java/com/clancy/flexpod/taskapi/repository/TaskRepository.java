package com.clancy.flexpod.taskapi.repository;

import com.clancy.flexpod.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
    // TODO: Add query methods as needed
}
