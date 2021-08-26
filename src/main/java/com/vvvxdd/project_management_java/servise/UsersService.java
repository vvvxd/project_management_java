package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.UsersRequestDto;
import com.vvvxdd.project_management_java.rest.dto.UsersResponseDto;

import java.util.List;
/**
 * Сервис для работы с пользователями
 */
public interface UsersService extends StandardService<UsersRequestDto, UsersResponseDto,Long>{
    /**
     * Метод получения пользователя по ID
     *
     * @param id - ID пользователя
     * @return - Tasks Response Dto
     */
    @Override
    UsersResponseDto getById(Long id);
    /**
     * Метод получения пользователей
     *
     * @return List Users Response Dto
     */
    @Override
    List<UsersResponseDto> getAll();
    /**
     * Метод создания пользователя
     *
     * @param usersRequestDto - DTO пользователя с заполненными полями без ID
     * @return - ID пользователя
     */
    @Override
    Long save(UsersRequestDto usersRequestDto);
    /**
     * Метод обновления пользователя.
     *
     * @param id - первичный ключ для пользователя
     * @param usersRequestDto  - DTO пользователя с полями для измениний
     */
    @Override
    void update(UsersRequestDto usersRequestDto, Long id);

    /**
     * Метод удаления пользователя
     *
     * @param id - первичный ключ для пользователя
     */
    @Override
    void deleteById(Long id);
}
