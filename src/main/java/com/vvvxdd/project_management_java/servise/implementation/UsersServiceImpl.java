package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.entity.UserEntity;
import com.vvvxdd.project_management_java.exception.IncorrectArgumentException;
import com.vvvxdd.project_management_java.exception.ProjectNotFoundException;
import com.vvvxdd.project_management_java.exception.RoleNotFoundException;
import com.vvvxdd.project_management_java.exception.UserNotFoundException;
import com.vvvxdd.project_management_java.mapper.UsersMapper;
import com.vvvxdd.project_management_java.repository.ProjectsRepository;
import com.vvvxdd.project_management_java.repository.RolesRepository;
import com.vvvxdd.project_management_java.repository.UsersRepository;
import com.vvvxdd.project_management_java.rest.dto.UsersRequestDto;
import com.vvvxdd.project_management_java.rest.dto.UsersResponseDto;
import com.vvvxdd.project_management_java.servise.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final ProjectsRepository projectsRepository;
    private final RolesRepository rolesRepository;

    public UsersServiceImpl(UsersRepository usersRepository, ProjectsRepository projectsRepository, RolesRepository rolesRepository) {
        this.usersRepository = usersRepository;
        this.projectsRepository = projectsRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UsersResponseDto getById(Long id) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(String.format("There is no user with id = %d", id))
        );
        return UsersMapper.INSTANCE.toDto(usersRepository.getById(id));
    }

    @Override
    public List<UsersResponseDto> getAll() {
        List<UsersResponseDto> responseDtos = usersRepository.findAll().stream().map(UsersMapper.INSTANCE::toDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public Long save(UsersRequestDto user) {
        UserEntity userEntity = UsersMapper.INSTANCE.toEntity(user);
        userEntity = usersRepository.save(userEntity);
        return userEntity.getUsersId();
    }

    @Override
    public void update(UsersRequestDto usersRequestDto, Long id) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow(
                () -> new IncorrectArgumentException(String.format("Person with Id = %d  not found.", id))
        );

        String newLastName = usersRequestDto.getLastName();
        String newMiddleName = usersRequestDto.getMiddleName();
        String newFirstMame = usersRequestDto.getFirstMame();
        if (StringUtils.hasText(newLastName) && StringUtils.hasText(newMiddleName) && StringUtils.hasText(newFirstMame)){
            userEntity.setFirstMame(newFirstMame);
            userEntity.setMiddleName(newMiddleName);
            userEntity.setLastName(newLastName);
        }else{
            throw new IllegalArgumentException("Person name can't be null or empty string");
        }

        if (projectsRepository.countAllByProjectId(usersRequestDto.getProjectId())>0) {
            userEntity.setProjectId(usersRequestDto.getProjectId());
        }else{
            throw new ProjectNotFoundException(String.format("There is no project with id = %d", id));
        }

        if (rolesRepository.countAllByRoleId(usersRequestDto.getRoleId())>0) {
            userEntity.setRoleId(usersRequestDto.getRoleId());
        }else{
            throw new RoleNotFoundException(String.format("There is no role with id = %d", id));
        }

        usersRepository.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(String.format("There is no user with id = %d", id))
        );
        usersRepository.deleteById(id);
    }
}
