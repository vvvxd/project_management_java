package com.vvvxdd.project_management_java.mapper;

import com.vvvxdd.project_management_java.entity.ProjectEntity;
import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectsResponseDto toDto(ProjectEntity projectEntity);

    ProjectEntity toEntity(ProjectsRequestDto projectDto);
}
