package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @Column(name = "attendance_id", nullable = false)
    private Integer attendanceId;

    @Column(name = "schedule_id", nullable = false)
    @NotNull(message = "Поле \"Расписание\" не может быть пустым")
    private Integer scheduleId;

    @Column(name = "people_id", nullable = false)
    @NotNull(message = "Поле \"Человек\" не может быть пустым")
    private Integer peopleId;

    @Column(name = "attendance_presenceflag", nullable = false)
    @NotNull(message = "Поле \"Флаг посещаемости\" не может быть пустым")
    private Integer attendancePresenceFlag;

    public Attendance() {
    }

    public Attendance(Integer attendanceId,
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
}
