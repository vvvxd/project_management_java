package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;


@Schema(description = "Релиз")
public class ReleasesResponseDto {

    @Schema(description = "Начало релизы")
    private Date startTime;

    @Schema(description = "Конец релизы")
    private Date completionTime;

    @Schema(description = "Статус релиза")
    private ReleaseStatus status;

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

    public ReleasesResponseDto() {
    }

    public ReleaseStatus getStatus() {
        return status;
    }

    public void setStatus(ReleaseStatus status) {
        this.status = status;
    }

    public ReleasesResponseDto(Date startTime, Date completionTime, ReleaseStatus status) {
        this.startTime = startTime;
        this.completionTime = completionTime;
        this.status = status;
    }
}