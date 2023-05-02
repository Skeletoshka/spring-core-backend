package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class AttendanceView {

    @Schema(description = "ИД посещаемости")
    @Column(name = "attendance_id")
    private Integer attendanceId;

    @Schema(description = "ИД расписания")
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Schema(description = "Время занятия")
    @Column(name = "schedule_date")
    private Date scheduleDate;

    @Schema(description = "Наименование программы обучения")
    @Column(name = "studyprogram_name")
    private String studyProgramName;

    @Schema(description = "ИД человека")
    @Column(name = "people_id")
    private Integer peopleId;

    @Schema(description = "Имя человека")
    @Column(name = "people_name")
    private String peopleName;

    @Schema(description = "Фамилия человека")
    @Column(name = "people_lastname")
    private String peopleLastName;

    @Schema(description = "Отчество человека")
    @Column(name = "people_middlename")
    private String peopleMiddleName;

    @Schema(description = "Отметка о посещаемости")
    @Column(name = "attendance_presenceflag")
    private Integer attendancePresenceFlag;

    public AttendanceView() {
    }

    public AttendanceView(Integer attendanceId,
                          Integer scheduleId,
                          Integer peopleId,
                          Integer attendancePresenceFlag) {
        this.attendanceId = attendanceId;
        this.scheduleId = scheduleId;
        this.peopleId = peopleId;
        this.attendancePresenceFlag = attendancePresenceFlag;
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

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
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

    public Integer getAttendancePresenceFlag() {
        return attendancePresenceFlag;
    }

    public void setAttendancePresenceFlag(Integer attendancePresenceFlag) {
        this.attendancePresenceFlag = attendancePresenceFlag;
    }
}
