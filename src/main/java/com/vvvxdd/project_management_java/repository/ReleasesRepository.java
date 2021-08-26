package com.vvvxdd.project_management_java.repository;

import com.vvvxdd.project_management_java.entity.ReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReleasesRepository extends JpaRepository<ReleaseEntity, Long> {
    Optional<List<ReleaseEntity>> findAllByReleaseId(Long releaseId);
    List<ReleaseEntity> findAllByProjectId(Long projectId);
}
