package com.vvvxdd.project_management_java.rest.dto;

import com.vvvxdd.project_management_java.config.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;



@Schema(description = "Задачи")
public class TasksResponseDto {

    @Schema(description = "ID релиза")
    private long Release_id;
    @Schema(description = "Статус задачи")
    private TaskStatus Status;
    @Schema(description = "ID проекта")
    private long Project_id;
    @Schema(description = "ID исполнителя")
    private long Executor_id;
    @Schema(description = "ID заказчика")
    private long Customer_id;

    public long getRelease_id() {
        return Release_id;
    }

    public void setRelease_id(long release_id) {
        Release_id = release_id;
    }

    public TaskStatus getStatus() {
        return Status;
    }

    public void setStatus(TaskStatus status) {
        Status = status;
    }

    public long getProject_id() {
        return Project_id;
    }

    public void setProject_id(long project_id) {
        Project_id = project_id;
    }

    public long getExecutor_id() {
        return Executor_id;
    }

    public void setExecutor_id(long executor_id) {
        Executor_id = executor_id;
    }

    public long getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(long customer_id) {
        Customer_id = customer_id;
    }

    public TasksResponseDto( long release_id, TaskStatus status, long project_id, long executor_id, long customer_id) {
        Release_id = release_id;
        Status = status;
        Project_id = project_id;
        Executor_id = executor_id;
        Customer_id = customer_id;
    }
}



