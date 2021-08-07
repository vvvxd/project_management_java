package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;

import java.util.List;

public interface RolesService extends StandardService<RolesRequestDto, RolesResponseDto,Long>{
    @Override
    RolesResponseDto getById(Long aLong);

    @Override
    List<RolesResponseDto> getAll();

    @Override
    RolesResponseDto save(RolesRequestDto s);

    @Override
    RolesResponseDto update(RolesRequestDto s, Long e);

    @Override
    RolesResponseDto deleteById(Long aLong);
}
