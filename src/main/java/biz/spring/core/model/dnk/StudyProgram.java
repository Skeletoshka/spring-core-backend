package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "studyprogram")
public class StudyProgram {

    public static int DOCUMENT_ID = 1;

    @Id
    @Column(name = "studyprogram_id", nullable = false)
    private Integer studyProgramId;

    @Column(name = "studyprogram_name", nullable = false)
    @Size(max = 100, message = "Поле \"Наименование программы обучения\" не может быть более {max} символов")
    @NotNull(message = "Поле \"Наименование программы обучения\" не может быть null")
    private String studyProgramName;

    @Column(name = "direction_id", nullable = false)
    @NotNull(message = "Поле \"Наименование направления\" не может быть null")
    private Integer directionId;

    @Column(name = "teacher_id", nullable = false)
    @NotNull(message = "Поле \"ИД учителя\" не может быть null")
    private Integer teacherId;

    @Column(name = "assistant_id", nullable = true)
    private Integer assistantId;


    public StudyProgram(){
    }


    public StudyProgram(Integer studyProgramId,
                        String studyProgramName,
                        Integer directionId,
                        Integer teacherId,
                        Integer assistantId) {
        this.studyProgramId = studyProgramId;
        this.studyProgramName = studyProgramName;
        this.directionId = directionId;
        this.teacherId = teacherId;
        this.assistantId = assistantId;
    }

    public Integer getStudyProgramId() { return studyProgramId; }

    public void setStudyProgramId(Integer studyProgramId) { this.studyProgramId = studyProgramId; }

    public String getStudyProgramName() { return studyProgramName; }

    public void setStudyProgramName(String studyProgramName) { this.studyProgramName = studyProgramName; }

    public Integer getDirectionId() { return directionId; }

    public void setDirectionId(Integer directionId) { this.directionId = directionId; }

    public Integer getTeacherId() { return teacherId; }

    public void setTeacherId(Integer teacherId) { this.teacherId = teacherId; }

    public Integer getAssistantId() { return assistantId; }

    public void setAssistantId(Integer assistantId) { this.assistantId = assistantId; }
}