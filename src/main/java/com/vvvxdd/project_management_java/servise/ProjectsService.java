package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;

import java.util.List;

public interface ProjectsService extends StandardService<ProjectsRequestDto, ProjectsResponseDto,Long> {
    @Override
    ProjectsResponseDto getById(Long id);

    @Override
    List<ProjectsResponseDto> getAll();

    @Override
    ProjectsResponseDto save(ProjectsRequestDto s);

    @Override
    ProjectsResponseDto update(ProjectsRequestDto s, Long id);

    @Override
    ProjectsResponseDto deleteById(Long id);
}
