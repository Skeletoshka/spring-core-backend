package biz.spring.core.dto.dnk;

import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.dnk.StudyProgram;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class StudyProgramDTO {

    @Schema(description = "ИД Программы обучения")
    private Integer studyProgramId;

    @Schema(description = "Наименование программы обучения")
    private String studyProgramName;

    @Schema(description = "ИД направления")
    private Integer directionId;

    @Schema(description = "ИД учителя")
    private Integer teacherId;

    @Schema(description = "ИД ассистента")
    private Integer assistantId;

    @Schema(description = "Наименование направления")
    private String directionName;

    @Schema(description = "Имя учителя")
    private String teacherName;

    @Schema(description = "Фамилия учителя")
    private String teacherLastName;

    @Schema(description = "Отчество учителя")
    private String teacherMiddleName;

    @Schema(description = "Имя ассистента")
    private String assistantName;

    @Schema(description = "Фамилия ассистента")
    private String assistantLastName;

    @Schema(description = "Отчество ассистента")
    private String assistantMiddleName;

    @Schema(description = "Номер образовательной программы")
    private String documentRealNumber;

    @Schema(description = "Дата создания образовательной программы")
    private Date documentRealDateCreate;

    @Schema(description = "ИД статуса документа")
    private Integer documentStatusId;

    @Schema(description = "Имя статуса")
    private String documentStatusName;

    public StudyProgramDTO(){
    }

    public StudyProgramDTO(Integer studyProgramId,
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

    public Integer getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(Integer studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public String getStudyProgramName() {
        return studyProgramName;
    }

    public void setStudyProgramName(String studyProgramName) {
        this.studyProgramName = studyProgramName;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Integer assistantId) {
        this.assistantId = assistantId;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
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

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getAssistantLastName() {
        return assistantLastName;
    }

    public void setAssistantLastName(String assistantLastName) {
        this.assistantLastName = assistantLastName;
    }

    public String getAssistantMiddleName() {
        return assistantMiddleName;
    }

    public void setAssistantMiddleName(String assistantMiddleName) {
        this.assistantMiddleName = assistantMiddleName;
    }

    public String getDocumentRealNumber() {
        return documentRealNumber;
    }

    public void setDocumentRealNumber(String documentRealNumber) {
        this.documentRealNumber = documentRealNumber;
    }

    public Date getDocumentRealDateCreate() {
        return documentRealDateCreate;
    }

    public void setDocumentRealDateCreate(Date documentRealDateCreate) {
        this.documentRealDateCreate = documentRealDateCreate;
    }

    public Integer getDocumentStatusId() {
        return documentStatusId;
    }

    public void setDocumentStatusId(Integer documentStatusId) {
        this.documentStatusId = documentStatusId;
    }

    public String getDocumentStatusName() {
        return documentStatusName;
    }

    public void setDocumentStatusName(String documentStatusName) {
        this.documentStatusName = documentStatusName;
    }

    public StudyProgram toEntity() { return toEntity(new StudyProgram()); }

    public StudyProgram toEntity(StudyProgram entity){
        entity.setStudyProgramId(this.studyProgramId);
        entity.setStudyProgramName(this.studyProgramName);
        entity.setDirectionId(this.directionId);
        entity.setTeacherId(this.teacherId);
        entity.setAssistantId(this.assistantId);
        return entity;
    }

    public DocumentReal toDocumentReal(){
        return toDocumentReal(new DocumentReal());
    }

    public DocumentReal toDocumentReal(DocumentReal documentReal){
        documentReal.setDocumentRealNumber(this.documentRealNumber);
        documentReal.setDocumentTransitId(this.documentStatusId);
        documentReal.setDocumentRealId(this.studyProgramId);
        documentReal.setDocumentRealDate(new Date());
        documentReal.setDocumentTypeId(StudyProgram.DOCUMENT_ID);
        return documentReal;
    }
}

