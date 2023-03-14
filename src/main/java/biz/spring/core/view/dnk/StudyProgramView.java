package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.Column;

public class StudyProgramView {
    @Schema(description = "ИД программы обучения")
    @Column(name = "studyprogram_id")
    private Integer studyProgramId;

    @Schema(description = "Наименование программы обучения")
    @Column(name = "studyprogram_name")
    private String studyProgramName;

    @Schema(description = "ИД направления")
    @Column(name = "direction_id")
    private Integer directionId;

    @Schema(description = "ИД учителя")
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Schema(description = "ИД ассистента")
    @Column(name = "assistant_id")
    private Integer assistantId;

    @Schema(description = "Наименование направления")
    @Column(name = "direction_name")
    private String directionName;

    @Schema(description = "Имя учителя")
    @Column(name = "teacher_name")
    private String teacherName;

    @Schema(description = "Фамилия учителя")
    @Column(name = "teacher_lastname")
    private String teacherLastName;

    @Schema(description = "Отчество учителя")
    @Column(name = "teacher_middlename")
    private String teacherMiddleName;

    @Schema(description = "Имя ассистента")
    @Column(name = "assistant_name")
    private String assistantName;

    @Schema(description = "Фамилия ассистента")
    @Column(name = "assistant_lastname")
    private String assistantLastName;

    @Schema(description = "Отчество ассистента")
    @Column(name = "assistant_middlename")
    private String assistantMiddleName;


    public StudyProgramView(){
    }


    public StudyProgramView(Integer studyProgramId,
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

    public String getDirectionName() { return directionName; }

    public void setDirectionName(String directionName) { this.directionName = directionName; }

    public String getTeacherName() { return teacherName; }

    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    public String getTeacherLastName() { return teacherLastName; }

    public void setTeacherLastName(String teacherLastName) { this.teacherLastName = teacherLastName; }

    public String getTeacherMiddleName() { return teacherMiddleName; }

    public void setTeacherMiddleName(String teacherMiddleName) { this.teacherMiddleName = teacherMiddleName; }

    public String getAssistantName() { return assistantName; }

    public void setAssistantName(String assistantName) { this.assistantName = assistantName; }

    public String getAssistantLastName() { return assistantLastName; }

    public void setAssistantLastName(String assistantLastName) { this.assistantLastName = assistantLastName; }

    public String getAssistantMiddleName() { return assistantMiddleName; }

    public void setAssistantMiddleName(String assistantMiddleName) { this.assistantMiddleName = assistantMiddleName; }
}
