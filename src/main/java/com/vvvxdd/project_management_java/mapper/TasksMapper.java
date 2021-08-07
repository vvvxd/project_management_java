package com.vvvxdd.project_management_java.mapper;

import com.vvvxdd.project_management_java.entity.TaskEntity;
import com.vvvxdd.project_management_java.rest.dto.TasksRequestDto;
import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TasksMapper {
    TasksMapper INSTANCE = Mappers.getMapper(TasksMapper.class);


    TasksResponseDto toDto(TaskEntity taskEntity);

    TaskEntity toEntity(TasksRequestDto taskDto);
}
