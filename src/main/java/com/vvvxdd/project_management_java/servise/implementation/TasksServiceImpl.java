package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.mapper.RolesMapper;
import com.vvvxdd.project_management_java.mapper.TasksMapper;
import com.vvvxdd.project_management_java.repository.TasksRepository;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import com.vvvxdd.project_management_java.rest.dto.TasksRequestDto;
import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;
import com.vvvxdd.project_management_java.servise.TasksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksServiceImpl implements TasksService {
    private final TasksRepository tasksRepository;

    public TasksServiceImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public TasksResponseDto getById(Long id) {
        return TasksMapper.INSTANCE.toDto(tasksRepository.getById(id));
    }

    @Override
    public List<TasksResponseDto> getAll() {
        List<TasksResponseDto> responseDtos = tasksRepository.findAll().stream().map(TasksMapper.INSTANCE::toDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public TasksResponseDto save(TasksRequestDto s) {
        return null;
    }

    @Override
    public TasksResponseDto update(TasksRequestDto s, Long e) {
        return null;
    }

    @Override
    public TasksResponseDto deleteById(Long aLong) {
        return null;
    }
}
