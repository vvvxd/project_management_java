package com.vvvxdd.project_management_java.entity;

import com.vvvxdd.project_management_java.rest.dto.ProjectStatus;
import com.vvvxdd.project_management_java.rest.dto.ReleaseStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "releases")
public class ReleaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "release_id")
    private long releaseId;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "completion_time")
    private Date completionTime;

    @Column(name = "release_status")
    @Enumerated(EnumType.STRING)
    private ReleaseStatus status;

    public ReleaseEntity() {

    }

    public ReleaseStatus getStatus() {
        return status;
    }

    public void setStatus(ReleaseStatus status) {
        this.status = status;
    }

    public ReleaseEntity(long releaseId, Date startTime, Date completionTime, ReleaseStatus status) {
        this.releaseId = releaseId;
        this.startTime = startTime;
        this.completionTime = completionTime;
        this.status = status;
    }

    public long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(long releaseId) {
        this.releaseId = releaseId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

}
