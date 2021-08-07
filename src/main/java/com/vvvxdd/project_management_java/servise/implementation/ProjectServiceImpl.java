package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.mapper.ProjectMapper;
import com.vvvxdd.project_management_java.repository.ProjectsRepository;
import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import com.vvvxdd.project_management_java.servise.ProjectsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectsService {
    private final ProjectsRepository projectsRepository;

    public ProjectServiceImpl(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    @Transactional
    @Override
    public ProjectsResponseDto getById(Long id) {
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
    public ProjectsResponseDto save(ProjectsRequestDto s) {
        return null;
    }

    @Transactional
    @Override
    public ProjectsResponseDto update(ProjectsRequestDto s, Long id) {
        return null;
    }

    @Transactional
    @Override
    public ProjectsResponseDto deleteById(Long id) {
        return null;
    }
}
