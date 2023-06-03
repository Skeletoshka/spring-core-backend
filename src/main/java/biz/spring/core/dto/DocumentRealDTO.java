package biz.spring.core.dto;

import biz.spring.core.model.DocumentReal;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class DocumentRealDTO {

    @Schema(description = "ИД документа")
    private Integer documentRealId;

    @Schema(description = "Типа документа")
    private Integer documentTypeId;

    @Schema(description = "Статус документа")
    private Integer documentTransitId;

    @Schema(description = "Имя документа")
    private String documentRealName;

    @Schema(description = "Номер документа")
    private String documentRealNumber;

    @Schema(description = "Дата создания документа")
    private Date documentRealDateCreate;

    @Schema(description = "Дата модификации документа")
    private Date documentRealDateModify;

    @Schema(description = "ИД пользователя")
    private Integer progUserId;

    @Schema(description = "Имя типа документа")
    private String documentTypeName;

    @Schema(description = "Имя пользователя")
    private String progUserName;

    public DocumentRealDTO() {
    }

    public DocumentRealDTO(Integer documentRealId,
                           Integer documentTypeId,
                           Integer documentTransitId,
                           String documentRealName,
                           String documentRealNumber,
                           Date documentRealDateCreate,
                           Date documentRealDateModify,
                           Integer progUserId) {
        this.documentRealId = documentRealId;
        this.documentTypeId = documentTypeId;
        this.documentTransitId = documentTransitId;
        this.documentRealName = documentRealName;
        this.documentRealNumber = documentRealNumber;
        this.documentRealDateCreate = documentRealDateCreate;
        this.documentRealDateModify = documentRealDateModify;
        this.progUserId = progUserId;
    }

    public DocumentReal toEntity(){
        return toEntity(new DocumentReal());
    }

    public DocumentReal toEntity(DocumentReal entity){
        entity.setDocumentTypeId(this.documentTypeId);
        entity.setDocumentRealId(this.documentRealId);
        entity.setDocumentRealNumber(this.documentRealNumber);
        entity.setDocumentTransitId(this.documentTransitId);
        return entity;
    }

    public Integer getDocumentRealId() {
        return documentRealId;
    }

    public void setDocumentRealId(Integer documentRealId) {
        this.documentRealId = documentRealId;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public Integer getDocumentTransitId() {
        return documentTransitId;
    }

    public void setDocumentTransitId(Integer documentTransitId) {
        this.documentTransitId = documentTransitId;
    }

    public String getDocumentRealName() {
        return documentRealName;
    }

    public void setDocumentRealName(String documentRealName) {
        this.documentRealName = documentRealName;
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

    public Date getDocumentRealDateModify() {
        return documentRealDateModify;
    }

    public void setDocumentRealDateModify(Date documentRealDateModify) {
        this.documentRealDateModify = documentRealDateModify;
    }

    public Integer getProgUserId() {
        return progUserId;
    }

    public void setProgUserId(Integer progUserId) {
        this.progUserId = progUserId;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    public String getProgUserName() {
        return progUserName;
    }

    public void setProgUserName(String progUserName) {
        this.progUserName = progUserName;
    }
}
