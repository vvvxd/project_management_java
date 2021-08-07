package com.vvvxdd.project_management_java.mapper;

import com.vvvxdd.project_management_java.entity.ReleaseEntity;
import com.vvvxdd.project_management_java.rest.dto.ReleasesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReleasesMapper {
    ReleasesMapper INSTANCE = Mappers.getMapper(ReleasesMapper.class);

    ReleasesResponseDto toDto(ReleaseEntity releaseEntity);

    ReleaseEntity toEntity(ReleasesRequestDto releaseDto);
}
