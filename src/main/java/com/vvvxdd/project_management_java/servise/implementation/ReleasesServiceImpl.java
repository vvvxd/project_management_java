package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.entity.ProjectEntity;
import com.vvvxdd.project_management_java.entity.ReleaseEntity;
import com.vvvxdd.project_management_java.entity.TaskEntity;
import com.vvvxdd.project_management_java.exception.IncorrectArgumentException;
import com.vvvxdd.project_management_java.exception.ProjectNotFoundException;
import com.vvvxdd.project_management_java.exception.ReleaseNotFoundException;
import com.vvvxdd.project_management_java.mapper.ProjectMapper;
import com.vvvxdd.project_management_java.mapper.ReleasesMapper;
import com.vvvxdd.project_management_java.repository.ReleasesRepository;
import com.vvvxdd.project_management_java.repository.TasksRepository;
import com.vvvxdd.project_management_java.rest.dto.*;
import com.vvvxdd.project_management_java.servise.ReleasesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReleasesServiceImpl implements ReleasesService {
    private final ReleasesRepository releasesRepository;
    private final TasksRepository tasksRepository;

    public ReleasesServiceImpl(ReleasesRepository releasesRepository, TasksRepository tasksRepository) {
        this.releasesRepository = releasesRepository;
        this.tasksRepository = tasksRepository;
    }

    @Transactional
    @Override
    public ReleasesResponseDto getById(Long id) {
        ReleaseEntity releaseEntity = releasesRepository.findById(id).orElseThrow(
                () -> new ReleaseNotFoundException(String.format("There is no release with id = %d", id))
        );
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
    public Long save(ReleasesRequestDto release) {
        ReleaseEntity releaseEntity = ReleasesMapper.INSTANCE.toEntity(release);
        releaseEntity = releasesRepository.save(releaseEntity);
        return releaseEntity.getReleaseId();
    }

    @Transactional
    @Override
    public void update(ReleasesRequestDto releasesRequestDto, Long id) {
        ReleaseEntity releaseEntity = releasesRepository.findById(id).orElseThrow(
                () -> new ReleaseNotFoundException(String.format("There is no release with id = %d", id))
        );

        if (releaseEntity.getStatus() == ReleaseStatus.DONE) {
            throw new IncorrectArgumentException("Can't change an already CLOSED release");
        }

        ReleaseStatus newReleaseStatus = releasesRequestDto.getStatus();
        if (newReleaseStatus == ReleaseStatus.DONE) {
            backlogTasksRelease(releaseEntity.getReleaseId()).stream()
                    .forEach(task -> {
                        if (task.getStatus() != TaskStatus.DONE) {
                            task.setStatus(TaskStatus.BACKLOG);
                            tasksRepository.save(task);
                        }
                    });
            releaseEntity.setCompletionTime(new Date());
            releaseEntity.setStatus(ReleaseStatus.DONE);
        }else {
            releaseEntity.setStatus(newReleaseStatus);
        }

        releasesRepository.save(releaseEntity);
    }


    private List<TaskEntity> backlogTasksRelease(Long releaseId) {
        List<TaskEntity> unfinishedTaskByRelease = tasksRepository
                .findAllByReleaseIdAndStatus(releaseId, TaskStatus.BACKLOG).orElse(new ArrayList<>());
        return unfinishedTaskByRelease;
    }


    public Integer countBacklogTask(Long releaseId) {
        return tasksRepository.countAllByReleaseIdAndStatusIsNot(releaseId, TaskStatus.BACKLOG);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        ReleaseEntity releaseEntity = releasesRepository.findById(id).orElseThrow(
                () -> new ReleaseNotFoundException(String.format("There is no release with id = %d", id))
        );
        releasesRepository.deleteById(id);
    }
}
