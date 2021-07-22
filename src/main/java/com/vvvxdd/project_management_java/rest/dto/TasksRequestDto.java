package com.vvvxdd.project_management_java.rest.dto;

import com.vvvxdd.project_management_java.config.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задачи")
public class TasksRequestDto {
    @Schema(description = "ID задачи")
    private long taskId;
    @Schema(description = "ID релиза")
    private long releaseId;
    @Schema(description = "Статус задачи")
    private TaskStatus status;
    @Schema(description = "ID проекта")
    private long projectId;
    @Schema(description = "ID исполнителя")
    private long executorId;
    @Schema(description = "ID заказчика")
    private long customerId;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(long releaseId) {
        this.releaseId = releaseId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(long executorId) {
        this.executorId = executorId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public TasksRequestDto(long taskId, long releaseId, TaskStatus status, long projectId, long executorId, long customerId) {
        this.taskId = taskId;
        this.releaseId = releaseId;
        this.status = status;
        this.projectId = projectId;
        this.executorId = executorId;
        this.customerId = customerId;
    }
}



