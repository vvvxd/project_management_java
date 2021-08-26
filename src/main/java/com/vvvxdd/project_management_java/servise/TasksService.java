package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import com.vvvxdd.project_management_java.rest.dto.TasksRequestDto;
import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;

import java.util.List;
/**
 * Сервис для работы с задачами
 */
public interface TasksService extends StandardService<TasksRequestDto, TasksResponseDto,Long>{
    /**
     * Метод получения задачи по ID
     *
     * @param id - ID задачи
     * @return - Tasks Response Dto
     */
    @Override
    TasksResponseDto getById(Long id);
    /**
     * Метод получения задач
     *
     * @return List Tasks Response Dto
     */
    @Override
    List<TasksResponseDto> getAll();
    /**
     * Метод создания задачи
     *
     * @param tasksRequestDto - DTO задачи с заполненными полями без ID
     * @return - ID задачи
     */
    @Override
    Long save(TasksRequestDto tasksRequestDto);
    /**
     * Метод обновления задачи.
     *
     * @param id - первичный ключ для задачи
     * @param tasksRequestDto  - DTO задачи с полями для измениний
     */
    @Override
    void update(TasksRequestDto tasksRequestDto, Long id);
    /**
     * Метод удаления задачи
     *
     * @param id - первичный ключ для задачи
     */
    @Override
    void deleteById(Long id);
}
