package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.mapper.TasksMapper;
import com.vvvxdd.project_management_java.mapper.UsersMapper;
import com.vvvxdd.project_management_java.repository.UsersRepository;
import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;
import com.vvvxdd.project_management_java.rest.dto.UsersRequestDto;
import com.vvvxdd.project_management_java.rest.dto.UsersResponseDto;
import com.vvvxdd.project_management_java.servise.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersResponseDto getById(Long id) {
        return UsersMapper.INSTANCE.toDto(usersRepository.getById(id));
    }

    @Override
    public List<UsersResponseDto> getAll() {
        List<UsersResponseDto> responseDtos = usersRepository.findAll().stream().map(UsersMapper.INSTANCE::toDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public UsersResponseDto save(UsersRequestDto s) {
        return null;
    }

    @Override
    public UsersResponseDto update(UsersRequestDto s, Long e) {
        return null;
    }

    @Override
    public UsersResponseDto deleteById(Long aLong) {
        return null;
    }
}
