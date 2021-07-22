package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;


@Schema(description = "Релиз")
public class ReleasesResponseDto {


    @Schema(description = "Начало релизы")
    private Date startTime;

    @Schema(description = "Конец релизы")
    private Date completionTime;

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

    public ReleasesResponseDto(Date startTime, Date completionTime) {
        this.startTime = startTime;
        this.completionTime = completionTime;
    }
}