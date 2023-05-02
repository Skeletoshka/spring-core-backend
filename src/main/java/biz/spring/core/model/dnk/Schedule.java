package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @Column(name = "schedule_id", nullable = false)
    private Integer scheduleId;

    @Column(name = "studyprogram_id", nullable = false)
    @NotNull(message = "Поле \"Программа обучения\" не может быть пустым")
    private Integer studyProgramId;

    @Column(name = "workgroup_id", nullable = false)
    @NotNull(message = "Поле \"Учебная группа\" не может быть пустым")
    private Integer workGroupId;

    @Column(name = "schedule_place", nullable = false)
    @NotNull(message = "Поле \"Место для занятия\" не может быть пустым")
    @Size(max = 20, message = "Поле \"Место для занятия\" не может иметь более {max} символов")
    private String schedulePlace;

    @Column(name = "schedule_date", nullable = false)
    @NotNull(message = "Поле \"Дата проведения занятия\" не может быть пустым")
    private Date scheduleDate;

    public Schedule() {
    }

    public Schedule(Integer scheduleId,
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

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
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
