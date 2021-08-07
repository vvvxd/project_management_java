package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.entity.ReleaseEntity;
import com.vvvxdd.project_management_java.mapper.ProjectMapper;
import com.vvvxdd.project_management_java.mapper.ReleasesMapper;
import com.vvvxdd.project_management_java.repository.ReleasesRepository;
import com.vvvxdd.project_management_java.rest.dto.ProjectsResponseDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesRequestDto;
import com.vvvxdd.project_management_java.rest.dto.ReleasesResponseDto;
import com.vvvxdd.project_management_java.servise.ReleasesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReleasesServiceImpl implements ReleasesService {
    private final ReleasesRepository releasesRepository;

    public ReleasesServiceImpl(ReleasesRepository releasesRepository) {
        this.releasesRepository = releasesRepository;
    }

    @Transactional
    @Override
    public ReleasesResponseDto getById(Long id) {
        return ReleasesMapper.INSTANCE.toDto(releasesRepository.getById(id));
    }

    @Transactional
    @Override
    public List<ReleasesResponseDto> getAll() {
        List<ReleasesResponseDto> responseDtos = releasesRepository.findAll().stream().map(ReleasesMapper.INSTANCE::toDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Transactional
    @Override
    public ReleasesResponseDto save(ReleasesRequestDto s) {
        return null;
    }

    @Transactional
    @Override
    public ReleasesResponseDto update(ReleasesRequestDto s, Long e) {
        return null;
    }

    @Transactional
    @Override
    public ReleasesResponseDto deleteById(Long aLong) {
        return null;
    }
}
