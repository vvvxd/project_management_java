package com.vvvxdd.project_management_java.repository;

import com.vvvxdd.project_management_java.entity.ReleaseEntity;
import com.vvvxdd.project_management_java.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<RoleEntity, Long> {
    Optional<List<RoleEntity>> findAllByName(String name);
    Integer countAllByRoleId(Long roleId);
}
