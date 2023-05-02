package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.Attendance;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class AttendanceDTO {

    @Schema(description = "ИД посещаемости")
    private Integer attendanceId;

    @Schema(description = "ИД расписания")
    private Integer scheduleId;

    @Schema(description = "Время занятия")
    private Date scheduleDate;

    @Schema(description = "Наименование программы обучения")
    private String studyProgramName;

    @Schema(description = "ИД человека")
    private Integer peopleId;

    @Schema(description = "Имя человека")
    private String peopleName;

    @Schema(description = "Фамилия человека")
    private String peopleLastName;

    @Schema(description = "Отчество человека")
    private String peopleMiddleName;

    @Schema(description = "Отметка о посещаемости")
    private Integer attendancePresenceFlag;

    public AttendanceDTO() {
    }

    public AttendanceDTO(Integer attendanceId,
                         Integer scheduleId,
                         Integer peopleId,
                         Integer attendancePresenceFlag) {
        this.attendanceId = attendanceId;
        this.scheduleId = scheduleId;
        this.peopleId = peopleId;
        this.attendancePresenceFlag = attendancePresenceFlag;
    }

    public Attendance toEntity(){
        return toEntity(new Attendance());
    }

    public Attendance toEntity(Attendance entity){
        entity.setAttendanceId(this.attendanceId);
        entity.setAttendancePresenceFlag(this.attendancePresenceFlag);
        entity.setPeopleId(this.peopleId);
        entity.setScheduleId(this.scheduleId);
        return entity;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public Integer getAttendancePresenceFlag() {
        return attendancePresenceFlag;
    }

    public void setAttendancePresenceFlag(Integer attendancePresenceFlag) {
        this.attendancePresenceFlag = attendancePresenceFlag;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStudyProgramName() {
        return studyProgramName;
    }

    public void setStudyProgramName(String studyProgramName) {
        this.studyProgramName = studyProgramName;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleLastName() {
        return peopleLastName;
    }

    public void setPeopleLastName(String peopleLastName) {
        this.peopleLastName = peopleLastName;
    }

    public String getPeopleMiddleName() {
        return peopleMiddleName;
    }

    public void setPeopleMiddleName(String peopleMiddleName) {
        this.peopleMiddleName = peopleMiddleName;
    }
}
