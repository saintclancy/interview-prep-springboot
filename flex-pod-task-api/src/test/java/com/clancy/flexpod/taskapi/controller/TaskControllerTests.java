package com.clancy.flexpod.taskapi.controller;

import com.clancy.flexpod.taskapi.model.Task;
import com.clancy.flexpod.taskapi.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@SuppressWarnings("removal")
@WebMvcTest(TaskController.class)
public class TaskControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TaskService service;

    @Test
    void createTaskShouldReturnOk() throws Exception {
        String payload = "{\"title\":\"test task\"}";
        Task saved = new Task("test task", false);
        saved.setId(1L);

        when(service.createTask(any(Task.class))).thenReturn(saved);

        mockMvc.perform(post("/tasks")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void getTaskNotFoundShouldReturn404() throws Exception {
        when(service.getTaskById(99L))
                .thenReturn(Optional.empty());

        mockMvc.perform(get("/tasks/99"))
                .andExpect(status().isNotFound());
    }

}
