package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.UsersRequestDto;
import com.vvvxdd.project_management_java.rest.dto.UsersResponseDto;

import java.util.List;

public interface UsersService extends StandardService<UsersRequestDto, UsersResponseDto,Long>{
    @Override
    UsersResponseDto getById(Long aLong);

    @Override
    List<UsersResponseDto> getAll();

    @Override
    UsersResponseDto save(UsersRequestDto s);

    @Override
    UsersResponseDto update(UsersRequestDto s, Long e);

    @Override
    UsersResponseDto deleteById(Long aLong);
}
