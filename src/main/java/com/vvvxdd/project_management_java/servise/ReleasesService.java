package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.entity.TaskEntity;
import com.vvvxdd.project_management_java.rest.dto.ReleasesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesResponseDto;

import java.util.List;
/**
 * Сервис для работы с релизами
 */
public interface ReleasesService extends StandardService<ReleasesRequestDto, ReleasesResponseDto,Long>{
    /**
     * Метод получения релиза по ID
     *
     * @param id - ID релиза
     * @return - Releases Response Dto
     */
    @Override
    ReleasesResponseDto getById(Long id);
    /**
     * Метод получения релизов
     *
     * @return List Releases Response Dto
     */
    @Override
    List<ReleasesResponseDto> getAll();
    /**
     * Метод создания релиза
     *
     * @param releasesRequestDto - DTO проекта с заполненными полями без ID
     * @return - ID проекта
     */
    @Override
    Long save(ReleasesRequestDto releasesRequestDto);

    /**
     * Метод для изменения релиза с возможностью изменить версию или сроки релиза
     *
     * @param id - первичный ключ для релиза
     * @param releasesRequestDto - DTO релиза с полями для измениний
     */
    @Override
    void update(ReleasesRequestDto releasesRequestDto, Long id);

    /**
     * Метод удаления релиза
     *
     * @param id - первичный ключ для релиза
     */
    @Override
    void deleteById(Long id);

    /**
     * Метод получения количества незавершенныз задач релиза
     *
     * @param releaseId - первичный ключ для релиза
     * @return - количество незавершенныз задач релиза
     */
    Integer countBacklogTask(Long releaseId);
}
