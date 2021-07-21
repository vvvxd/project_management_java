package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;


@Schema(description = "Релиз")
public class ReleasesResponseDto {


    @Schema(description = "Начало релизы")
    private Date Start_time;

    @Schema(description = "Конец релизы")
    private Date Completion_time;


    public Date getStart_time() {
        return Start_time;
    }

    public void setStart_time(Date start_time) {
        Start_time = start_time;
    }

    public Date getCompletion_time() {
        return Completion_time;
    }

    public void setCompletion_time(Date completion_time) {
        Completion_time = completion_time;
    }

    public ReleasesResponseDto(Date start_time, Date completion_time) {
        Start_time = start_time;
        Completion_time = completion_time;
    }
}