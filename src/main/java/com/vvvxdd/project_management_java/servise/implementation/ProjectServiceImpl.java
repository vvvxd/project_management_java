package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.entity.ProjectEntity;
import com.vvvxdd.project_management_java.exception.IncorrectArgumentException;
import com.vvvxdd.project_management_java.exception.ProjectNotFoundException;
import com.vvvxdd.project_management_java.mapper.ProjectMapper;
import com.vvvxdd.project_management_java.repository.ProjectsRepository;
import com.vvvxdd.project_management_java.repository.ReleasesRepository;
import com.vvvxdd.project_management_java.rest.dto.ProjectStatus;
import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import com.vvvxdd.project_management_java.rest.dto.ReleaseStatus;
import com.vvvxdd.project_management_java.servise.ProjectsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectsService {
    private final ProjectsRepository projectsRepository;
    private final ReleasesRepository releasesRepository;
    public ProjectServiceImpl(ProjectsRepository projectsRepository, ReleasesRepository releasesRepository) {
        this.projectsRepository = projectsRepository;
        this.releasesRepository = releasesRepository;
    }

    @Transactional
    @Override
    public ProjectsResponseDto getById(Long id) {
        ProjectEntity projectEntity = projectsRepository.findById(id).orElseThrow(
                () -> new ProjectNotFoundException(String.format("There is no project with id = %d", id)));
        return ProjectMapper.INSTANCE.toDto(projectsRepository.getById(id));
    }

    @Transactional
    @Override
    public List<ProjectsResponseDto> getAll() {
        List<ProjectsResponseDto> responseDtos = projectsRepository.findAll().stream().map(ProjectMapper.INSTANCE::toDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Transactional
    @Override
    public Long save(ProjectsRequestDto project) {
        ProjectEntity projectEntity = ProjectMapper.INSTANCE.toEntity(project);
        projectEntity = projectsRepository.save(projectEntity);
        return projectEntity.getProjectId();
    }

    @Transactional
    @Override
    public void update(ProjectsRequestDto projectsRequestDto, Long id) {
        ProjectEntity projectEntity = projectsRepository.findById(id).orElseThrow(
                () -> new ProjectNotFoundException(String.format("There is no project with id = %d", id))
        );

        if (projectEntity.getStatus() == ProjectStatus.NOT_ACTIVE) {
            throw new IncorrectArgumentException("Can't change an already NOT ACTIVE project.");
        }

        ProjectStatus newStatus = projectsRequestDto.getStatus();
        if (newStatus == ProjectStatus.NOT_ACTIVE) {
            if (releasesRepository.findAllByProjectId(projectsRequestDto.getProjectId()).stream().anyMatch(release -> release.getStatus() != ReleaseStatus.IN_PROGRESS)) {
                throw new IncorrectArgumentException("Can't close the project containing a release in a not IN PROGRESS state.");
            }
        }
        projectEntity.setStatus(newStatus);

        String newName = projectsRequestDto.getProjectName();
        if (StringUtils.hasText(newName)) {
            projectEntity.setProjectName(newName);
        }else{
            throw new IllegalArgumentException("Project name can't be an empty string");
        }

        projectsRepository.save(projectEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        ProjectEntity projectEntity = projectsRepository.findById(id).orElseThrow(
                () -> new ProjectNotFoundException(String.format("There is no project with id = %d", id))
        );
        projectsRepository.deleteById(id);
    }
}
