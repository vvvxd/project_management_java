package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import com.vvvxdd.project_management_java.rest.dto.TasksRequestDto;
import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;

import java.util.List;

public interface TasksService extends StandardService<TasksRequestDto, TasksResponseDto,Long>{
    @Override
    TasksResponseDto getById(Long aLong);

    @Override
    List<TasksResponseDto> getAll();

    @Override
    TasksResponseDto save(TasksRequestDto s);

    @Override
    TasksResponseDto update(TasksRequestDto s, Long e);

    @Override
    TasksResponseDto deleteById(Long aLong);
}
