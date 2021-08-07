package com.vvvxdd.project_management_java.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private long usersId;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstMame;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "project_id")
    private Long projectId;

    public UserEntity() {
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstMame() {
        return firstMame;
    }

    public void setFirstMame(String firstMame) {
        this.firstMame = firstMame;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public UserEntity(long usersId, Long roleId, String lastName, String firstMame, String middleName, Long projectId) {
        this.usersId = usersId;
        this.roleId = roleId;
        this.lastName = lastName;
        this.firstMame = firstMame;
        this.middleName = middleName;
        this.projectId = projectId;
    }
}
