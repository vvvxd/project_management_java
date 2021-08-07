package com.vvvxdd.project_management_java.repository;

import com.vvvxdd.project_management_java.entity.ReleaseEntity;
import com.vvvxdd.project_management_java.entity.TaskEntity;
import com.vvvxdd.project_management_java.entity.UserEntity;
import com.vvvxdd.project_management_java.rest.dto.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TasksRepository  extends JpaRepository<TaskEntity, Long> {
    Optional<List<TaskEntity>> findAllByTaskId(Long taskId);

    Optional<List<TaskEntity>> findAllByReleaseId(Long releaseId);

    Optional<List<TaskEntity>> findAllByExecutorId(Long executorId);

    Optional<List<TaskEntity>> findAllByCustomerId(Long customerId);

    Optional<List<TaskEntity>> findAllByStatus(TaskStatus status);

    Optional<List<TaskEntity>> findAllByReleaseIdAndExecutorIdAndStatus(
            Long releaseId, Long executorId, TaskStatus status
    );
}
