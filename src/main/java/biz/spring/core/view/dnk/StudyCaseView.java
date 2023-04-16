package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class StudyCaseView {

    @Schema(description = "ИД Кейса")
    @Column(name = "studycase_id")
    private Integer studyCaseId;

    @Schema(description = "ИД Программы обучения")
    @Column(name = "studyprogram_id")
    private Integer studyProgramId;

    @Schema(description = "Наименование Кейса")
    @Column(name = "studycase_name")
    private String studyCaseName;

    @Schema(description = "Описание Кейса")
    @Column(name = "studycase_desc")
    private String studyCaseDesc;

    @Schema(description = "Нумерация Кейса")
    @Column(name = "studycase_num")
    private Integer studyCaseNum;

    @Schema(description = "Видимость Кейса")
    @Column(name = "studycase_visible")
    private Integer studyCaseVisible;

    public StudyCaseView() {
    }

    public StudyCaseView(Integer studyCaseId,
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
