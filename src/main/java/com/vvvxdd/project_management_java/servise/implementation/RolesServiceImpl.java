package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.mapper.ReleasesMapper;
import com.vvvxdd.project_management_java.mapper.RolesMapper;
import com.vvvxdd.project_management_java.repository.RolesRepository;
import com.vvvxdd.project_management_java.rest.dto.ReleasesResponseDto;
import com.vvvxdd.project_management_java.rest.dto.RolesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.RolesResponseDto;
import com.vvvxdd.project_management_java.servise.RolesService;
import org.springframework.stereotype.Service;

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
        return RolesMapper.INSTANCE.toDto(rolesRepository.getById(id));
    }

    @Override
    public List<RolesResponseDto> getAll() {
        List<RolesResponseDto> responseDtos = rolesRepository.findAll().stream().map(RolesMapper.INSTANCE::toDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public RolesResponseDto save(RolesRequestDto s) {
        return null;
    }

    @Override
    public RolesResponseDto update(RolesRequestDto s, Long e) {
        return null;
    }

    @Override
    public RolesResponseDto deleteById(Long aLong) {
        return null;
    }
}
