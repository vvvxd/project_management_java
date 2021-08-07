package com.vvvxdd.project_management_java.repository;

import com.vvvxdd.project_management_java.entity.RoleEntity;
import com.vvvxdd.project_management_java.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<UserEntity, Long> {
    Optional<List<UserEntity>> findAllByRoleId(Long roleId);
}
