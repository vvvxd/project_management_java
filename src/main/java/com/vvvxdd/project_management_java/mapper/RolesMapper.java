package com.vvvxdd.project_management_java.mapper;

import com.vvvxdd.project_management_java.entity.RoleEntity;
import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolesMapper {
    RolesMapper INSTANCE = Mappers.getMapper(RolesMapper.class);

    RolesResponseDto toDto(RoleEntity roleEntity);

    RoleEntity toEntity(RolesRequestDto roleDto);
}
