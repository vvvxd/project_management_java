package com.vvvxdd.project_management_java.rest.dto;

import com.vvvxdd.project_management_java.config.ProjectStatus;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект")
public class ProjectsRequestDto {
    @Schema(description = "Проект ID")
    private long Project_id;
    @Schema(description = "Название проекта")
    private String Project_name;

    @Schema(description = "Статус проекта")
    private ProjectStatus status;

    public ProjectsRequestDto(long project_id, String project_name, ProjectStatus status) {
        Project_id = project_id;
        Project_name = project_name;
        this.status = status;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public long getProject_id() {
        return Project_id;
    }

    public void setProject_id(long project_id) {
        Project_id = project_id;
    }

    public String getProject_name() {
        return Project_name;
    }

    public void setProject_name(String project_name) {
        Project_name = project_name;
    }

}
