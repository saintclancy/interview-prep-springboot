package com.clancy.flexpod.taskapi.service;

import com.clancy.flexpod.taskapi.model.Task;
import com.clancy.flexpod.taskapi.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTests {

    @Mock
    private TaskRepository repo;

    @InjectMocks
    private TaskServiceImpl service;

    @Test
    void shouldCreateTask() {
        Task input = new Task("Interview with Lowes", false);
        when(repo.save(any(Task.class))).thenAnswer(inv -> {
            Task t = inv.getArgument(0);
            t.setId(1L);
            return t;
        });

        Task saved = service.createTask(input);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo("Interview with Lowes");
        verify(repo, times(1)).save(any(Task.class));
    }
}
