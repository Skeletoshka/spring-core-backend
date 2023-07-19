package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class AttendanceReportView {

    @Schema(description = "ИД посещаемости")
    @Column(name = "attendance_id")
    private Integer attendanceId;

    @Schema(description = "Имя ученика")
    @Column(name = "people_name")
    private String peopleName;

    @Schema(description = "Фамилия ученика")
    @Column(name = "people_lastname")
    private String peopleLastName;

    @Schema(description = "Фамилия ученика")
    @Column(name = "people_middlename")
    private String peopleMiddleName;

    @Schema(description = "Отметка о посещаемости")
    @Column(name = "attendance_presenceflag")
    private Integer attendancePresenceFlag;

    @Schema(description = "Наименование программы обучения")
    @Column(name = "studyprogram_name")
    private String studyProgramName;

    @Schema(description = "Наименование учебной группы")
    @Column(name = "workgroup_name")
    private String workGroupName;

    @Schema(description = "Дата и время проведения занятия")
    @Column(name = "schedule_date")
    private Date scheduleDate;

    @Schema(description = "Имя преподавателя")
    @Column(name = "teacher_name")
    private String teacherName;

    @Schema(description = "Фамилия преподавателя")
    @Column(name = "teacher_lastname")
    private String teacherLastName;

    @Schema(description = "Отчество ученика")
    @Column(name = "teacher_middlename")
    private String teacherMiddleName;

    public AttendanceReportView() {
    }

    public AttendanceReportView(
            Integer attendanceId,
            String peopleName,
            String peopleLastName,
            String peopleMiddleName,
            Integer attendancePresenceFlag,
            String studyProgramName,
            String workGroupName,
            Date scheduleDate,
            String teacherName,
            String teacherLastName,
            String teacherMiddleName) {
        this.attendanceId = attendanceId;
        this.peopleName = peopleName;
        this.peopleLastName = peopleLastName;
        this.peopleMiddleName = peopleMiddleName;
        this.attendancePresenceFlag = attendancePresenceFlag;
        this.studyProgramName = studyProgramName;
        this.workGroupName = workGroupName;
        this.scheduleDate = scheduleDate;
        this.teacherName = teacherName;
        this.teacherLastName = teacherLastName;
        this.teacherMiddleName = teacherMiddleName;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
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

    public String getStudyProgramName() {
        return studyProgramName;
    }

    public void setStudyProgramName(String studyProgramName) {
        this.studyProgramName = studyProgramName;
    }

    public String getWorkGroupName() {
        return workGroupName;
    }

    public void setWorkGroupName(String workGroupName) {
        this.workGroupName = workGroupName;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public String getTeacherMiddleName() {
        return teacherMiddleName;
    }

    public void setTeacherMiddleName(String teacherMiddleName) {
        this.teacherMiddleName = teacherMiddleName;
    }
}
