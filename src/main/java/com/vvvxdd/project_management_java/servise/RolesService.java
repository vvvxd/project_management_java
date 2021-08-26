package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;

import java.util.List;
/**
 * Сервис для работы с ролями
 */
public interface RolesService extends StandardService<RolesRequestDto, RolesResponseDto,Long>{
    /**
     * Метод получения роли по ID
     *
     * @param id - ID роли
     * @return - Roles Response Dto
     */
    @Override
    RolesResponseDto getById(Long id);
    /**
     * Метод получения ролей
     *
     * @return List Roles Response Dto
     */
    @Override
    List<RolesResponseDto> getAll();
    /**
     * Метод создания роли
     *
     * @param rolesRequestDto - DTO роли с заполненными полями без ID
     * @return - ID роли
     */
    @Override
    Long save(RolesRequestDto rolesRequestDto);
    /**
     * Метод обновления роли.
     *
     * @param id - первичный ключ для роли
     * @param rolesRequestDto  - DTO роли с полями для измениний
     */
    @Override
    void update(RolesRequestDto rolesRequestDto, Long id);
    /**
     * Метод удаления роли
     *
     * @param id - первичный ключ для роли
     */
    @Override
    void deleteById(Long id);
}
