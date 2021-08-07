package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект")
public class ProjectsRequestDto {
    @Schema(description = "Проект ID")
    private long projectId;
    @Schema(description = "Название проекта")
    private String projectName;
    @Schema(description = "Статус проекта")
    private ProjectStatus status;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public ProjectsRequestDto(long projectId, String projectName, ProjectStatus status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.status = status;
    }
}
