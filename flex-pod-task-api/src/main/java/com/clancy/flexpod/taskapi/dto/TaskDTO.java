package com.clancy.flexpod.taskapi.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskDTO {

    private long id;

    @NotBlank(message = "title is required")
    private String title;

    private Boolean completed;

    public TaskDTO() {}

    public TaskDTO(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
