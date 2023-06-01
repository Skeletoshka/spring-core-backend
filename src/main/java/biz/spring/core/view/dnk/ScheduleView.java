package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class ScheduleView {

    @Schema(description = "ИД расписания")
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Schema(description = "ИД программы обучения")
    @Column(name = "studyprogram_id")
    private Integer studyProgramId;

    @Schema(description = "Наименование программы обучения")
    @Column(name = "studyprogram_name")
    private String studyProgramName;

    @Schema(description = "ИД учебной группы")
    @Column(name = "workgroup_id")
    private Integer workGroupId;

    @Schema(description = "Наименование учебной группы")
    @Column(name = "workgroup_name")
    private String workGroupName;

    @Schema(description = "Место проведения занятия расписания")
    @Column(name = "schedule_place")
    private String schedulePlace;

    @Schema(description = "Дата проведения занятия")
    @Column(name = "schedule_date")
    private Date scheduleDate;

    public ScheduleView() {
    }

    public ScheduleView(Integer scheduleId,
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