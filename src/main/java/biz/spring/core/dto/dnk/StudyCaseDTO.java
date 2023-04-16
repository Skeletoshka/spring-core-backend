package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.StudyCase;
import io.swagger.v3.oas.annotations.media.Schema;

public class StudyCaseDTO {

    @Schema(description = "ИД Кейса")
    private Integer studyCaseId;

    @Schema(description = "ИД Программы обучения")
    private Integer studyProgramId;

    @Schema(description = "Наименование Кейса")
    private String studyCaseName;

    @Schema(description = "Описание Кейса")
    private String studyCaseDesc;

    @Schema(description = "Нумерация Кейса")
    private Integer studyCaseNum;

    @Schema(description = "Видимость Кейса")
    private Integer studyCaseVisible;

    public StudyCaseDTO() {
    }

    public StudyCaseDTO(Integer studyCaseId,
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

    public StudyCase toEntity() { return toEntity(new StudyCase()); }

    public StudyCase toEntity(StudyCase entity){
        entity.setStudyCaseId(this.studyCaseId);
        entity.setStudyProgramId(this.studyProgramId);
        entity.setStudyCaseName(this.studyCaseName);
        entity.setStudyCaseDesc(this.studyCaseDesc);
        entity.setStudyCaseNum(this.studyCaseNum);
        entity.setStudyCaseVisible(this.studyCaseVisible);
        return entity;
    }
}
