package com.vvvxdd.project_management_java.servise;

import com.vvvxdd.project_management_java.rest.dto.ReleasesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesResponseDto;

import java.util.List;

public interface ReleasesService extends StandardService<ReleasesRequestDto, ReleasesResponseDto,Long>{
    @Override
    ReleasesResponseDto getById(Long aLong);

    @Override
    List<ReleasesResponseDto> getAll();

    @Override
    ReleasesResponseDto save(ReleasesRequestDto s);

    @Override
    ReleasesResponseDto update(ReleasesRequestDto s, Long e);

    @Override
    ReleasesResponseDto deleteById(Long aLong);
}
