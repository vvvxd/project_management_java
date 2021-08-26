package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.ProjectsRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;

import java.util.List;

/**
 * Сервис для работы с проектами
 */
public interface ProjectsService extends StandardService<ProjectsRequestDto, ProjectsResponseDto, Long> {
    /**
     * Метод получения проекта по его ID
     *
     * @param id - первичный ключ для проекта
     * @return Projects Response Dto
     */
    @Override
    ProjectsResponseDto getById(Long id);
    /**
     * Метод получения проектов
     *
     * @return List Projects Response Dto
     */
    @Override
    List<ProjectsResponseDto> getAll();

    /**
     * Метод создания проекта
     *
     * @param projectsRequestDto - DTO проекта с заполненными полями без ID
     * @return - ID проекта
     */
    @Override
    Long save(ProjectsRequestDto projectsRequestDto);

    /**
     * Метод обновления проекта.
     *
     * @param id - первичный ключ для проекта
     * @param projectsRequestDto  - DTO проекта с полями для измениний
     */
    @Override
    void update(ProjectsRequestDto projectsRequestDto, Long id);

    /**
     * Метод удаления проекта
     *
     * @param id - первичный ключ для проекта
     */
    @Override
    void deleteById(Long id);
}
