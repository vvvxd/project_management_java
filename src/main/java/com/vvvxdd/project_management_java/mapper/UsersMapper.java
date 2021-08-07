package com.vvvxdd.project_management_java.mapper;

import com.vvvxdd.project_management_java.entity.UserEntity;
import com.vvvxdd.project_management_java.rest.dto.UsersRequestDto;
import com.vvvxdd.project_management_java.rest.dto.UsersResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    UsersResponseDto toDto(UserEntity userEntity);

    UserEntity toEntity(UsersRequestDto userDto);
}
