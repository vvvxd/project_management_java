package com.vvvxdd.project_management_java.entity;

import com.vvvxdd.project_management_java.rest.dto.TaskStatus;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long taskId;


    @Column(name = "release_id")
    private Long releaseId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;


    @Column(name = "project_id")
    private Long projectId;


    @Column(name = "executor")
    private Long executorId;


    @Column(name = "customer")
    private Long customerId;

    public TaskEntity() {
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public TaskEntity(long taskId, Long releaseId, TaskStatus status, Long projectId, Long executorId, Long customerId) {
        this.taskId = taskId;
        this.releaseId = releaseId;
        this.status = status;
        this.projectId = projectId;
        this.executorId = executorId;
        this.customerId = customerId;
    }
}
