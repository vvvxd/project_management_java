package com.vvvxdd.project_management_java.repository;

import com.vvvxdd.project_management_java.entity.ProjectEntity;
import com.vvvxdd.project_management_java.rest.dto.ProjectStatus;

import com.vvvxdd.project_management_java.rest.dto.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectsRepository extends JpaRepository<ProjectEntity, Long> {
    Integer countAllByProjectId(Long projectId);
}

