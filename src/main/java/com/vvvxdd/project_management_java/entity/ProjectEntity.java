package com.vvvxdd.project_management_java.entity;

import com.vvvxdd.project_management_java.rest.dto.ProjectStatus;
import javax.persistence.*;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    public ProjectEntity() {

    }

    public ProjectEntity(long projectId, String projectName, ProjectStatus status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.status = status;
    }

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


}
