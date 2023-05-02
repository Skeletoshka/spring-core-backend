package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.Schedule;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class ScheduleDTO {
    @Schema(description = "ИД расписания")
    private Integer scheduleId;

    @Schema(description = "ИД программы обучения")
    private Integer studyProgramId;

    @Schema(description = "Наименование программы обучения")
    private String studyProgramName;

    @Schema(description = "ИД учебной группы")
    private Integer workGroupId;

    @Schema(description = "Наименование учебной группы")
    private String workGroupName;

    @Schema(description = "Место проведения занятия расписания")
    private String schedulePlace;

    @Schema(description = "Дата проведения занятия")
    private Date scheduleDate;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Integer scheduleId,
                       Integer studyProgramId,
                       Integer workGroupId,
                       String schedulePlace,
                       Date scheduleDate) {
        this.scheduleId = scheduleId;
        this.studyProgramId = studyProgramId;
        this.workGroupId = workGroupId;
        this.schedulePlace = schedulePlace;
        this.scheduleDate = scheduleDate;
    }

    public Schedule toEntity(){
        return toEntity(new Schedule());
    }

    public Schedule toEntity(Schedule entity){
        entity.setScheduleId(this.scheduleId);
        entity.setWorkGroupId(this.workGroupId);
        entity.setStudyProgramId(this.studyProgramId);
        entity.setScheduleDate(this.scheduleDate);
        entity.setSchedulePlace(this.schedulePlace);
        return entity;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(Integer studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public String getStudyProgramName() {
        return studyProgramName;
    }

    public void setStudyProgramName(String studyProgramName) {
        this.studyProgramName = studyProgramName;
    }

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
    }

    public String getWorkGroupName() {
        return workGroupName;
    }

    public void setWorkGroupName(String workGroupName) {
        this.workGroupName = workGroupName;
    }

    public String getSchedulePlace() {
        return schedulePlace;
    }

    public void setSchedulePlace(String schedulePlace) {
        this.schedulePlace = schedulePlace;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
