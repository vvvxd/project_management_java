package com.vvvxdd.project_management_java.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Релиз")
public class ReleasesRequestDto {

    @Schema(description = "Релиз ID")
    private long Release_id;

    @Schema(description = "Начало релизы")
    private Date Start_time;

    @Schema(description = "Конец релизы")
    private Date Completion_time;

    public long getRelease_id() {
        return Release_id;
    }

    public void setRelease_id(long release_id) {
        Release_id = release_id;
    }

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

    public ReleasesRequestDto(long release_id, Date start_time, Date completion_time) {
        Release_id = release_id;
        Start_time = start_time;
        Completion_time = completion_time;
    }
}
