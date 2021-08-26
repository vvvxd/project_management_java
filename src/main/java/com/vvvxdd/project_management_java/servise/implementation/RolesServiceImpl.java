package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.entity.ReleaseEntity;
import com.vvvxdd.project_management_java.entity.RoleEntity;
import com.vvvxdd.project_management_java.exception.IncorrectArgumentException;
import com.vvvxdd.project_management_java.exception.ReleaseNotFoundException;
import com.vvvxdd.project_management_java.mapper.ReleasesMapper;
import com.vvvxdd.project_management_java.mapper.RolesMapper;
import com.vvvxdd.project_management_java.repository.RolesRepository;
import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import com.vvvxdd.project_management_java.servise.RolesService;
import org.springframework.stereotype.Service;


import com.vvvxdd.project_management_java.exception.RoleNotFoundException;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public RolesResponseDto getById(Long id) {
        RoleEntity roleEntity = rolesRepository.findById(id).orElseThrow(
                () -> new RoleNotFoundException(String.format("There is no role with id = %d", id))
        );
        return RolesMapper.INSTANCE.toDto(rolesRepository.getById(id));
    }

    @Override
    public List<RolesResponseDto> getAll() {
        List<RolesResponseDto> responseDtos = rolesRepository.findAll().stream().map(RolesMapper.INSTANCE::toDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public Long save(RolesRequestDto role) {
        RoleEntity roleEntity = RolesMapper.INSTANCE.toEntity(role);
        roleEntity = rolesRepository.save(roleEntity);
        return roleEntity.getRoleId();
    }

    @Override
    public void update(RolesRequestDto rolesRequestDto, Long id) {
        RoleEntity roleEntity = rolesRepository.findById(id).orElseThrow(
                () -> new RoleNotFoundException(String.format("There is no role with id = %d", id))
        );
        if (StringUtils.hasText(roleEntity.getName())){
            roleEntity.setName(rolesRequestDto.getName());
        }else{
            throw new IncorrectArgumentException("Incorrect role");
        }
        rolesRepository.save(roleEntity);
    }

    @Override
    public void deleteById(Long id)  {
        RoleEntity roleEntity = rolesRepository.findById(id).orElseThrow(
                () -> new RoleNotFoundException(String.format("There is no role with id = %d", id))
        );
        rolesRepository.deleteById(id);
    }
}
