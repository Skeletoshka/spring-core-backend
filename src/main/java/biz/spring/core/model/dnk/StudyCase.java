package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="studycase")
public class StudyCase {

    @Id
    @Column(name = "studycase_id", nullable = false)
    private Integer studyCaseId;

    @Column(name = "studyprogram_id", nullable = false)
    @NotNull(message = "Поле \"ИД программы обучения\" не может быть NULL")
    private Integer studyProgramId;

    @Column(name = "studycase_name", nullable = false)
    @Size(max = 255, message = "Поле \"Наименование кейса\" не может быть более {max} символов")
    @NotNull(message = "Поле \"Наименование кейса\" не может быть null")
    private String studyCaseName;

    @Column(name = "studycase_desc", nullable = true)
    @Size(max = 255, message = "Поле \"Описание кейса\" не может быть более {max} символов")
    private String studyCaseDesc;

    @Column(name = "studycase_num", nullable = false)
    @NotNull(message = "Поле \"Нумерация кейса\" не может быть NULL")
    private Integer studyCaseNum;

    @Column(name = "studycase_visible", nullable = false)
    @NotNull(message = "Поле \"Видимость кейса\" не может быть NULL")
    private Integer studyCaseVisible;



    public StudyCase() {

    }

    public StudyCase(Integer studyCaseId,
                Integer studyProgramId,
                String studyCaseName,
                String studyCaseDesc,
                Integer studyCaseNum,
                Integer studyCaseVisible) {
        this.studyCaseId = studyCaseId;
        this.studyProgramId = studyProgramId;
        this.studyCaseName = studyCaseName;
        this.studyCaseDesc = studyCaseDesc;
        this.studyCaseNum = studyCaseNum;
        this.studyCaseVisible = studyCaseVisible;
    }

    public Integer getStudyCaseId() {
        return studyCaseId;
    }

    public void setStudyCaseId(Integer studyCaseId) {
        this.studyCaseId = studyCaseId;
    }

    public Integer getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(Integer studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public String getStudyCaseName() {
        return studyCaseName;
    }

    public void setStudyCaseName(String studyCaseName) {
        this.studyCaseName = studyCaseName;
    }

    public String getStudyCaseDesc() {
        return studyCaseDesc;
    }

    public void setStudyCaseDesc(String studyCaseDesc) {
        this.studyCaseDesc = studyCaseDesc;
    }

    public Integer getStudyCaseNum() {
        return studyCaseNum;
    }

    public void setStudyCaseNum(Integer studyCaseNum) {
        this.studyCaseNum = studyCaseNum;
    }

    public Integer getStudyCaseVisible() {
        return studyCaseVisible;
    }

    public void setStudyCaseVisible(Integer studyCaseVisible) {
        this.studyCaseVisible = studyCaseVisible;
    }
}
