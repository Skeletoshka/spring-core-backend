package biz.spring.core.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class DocumentRealDTO {

    @Schema(description = "ИД документа")
    private Integer documentRealId;

    @Schema(description = "Типа документа")
    private Integer documentId;

    @Schema(description = "Статус документа")
    private Integer documentTransitId;

    @Schema(description = "Имя документа")
    private String documentRealName;

    @Schema(description = "Номер документа")
    private String documentRealNumber;

    @Schema(description = "Дата создания документа")
    private Date documentRealDate;

    @Schema(description = "Дата модификации документа")
    private Date documentRealDateModify;

    @Schema(description = "ИД пользователя")
    private Integer progUserId;

    public DocumentRealDTO() {
    }

    public DocumentRealDTO(Integer documentRealId,
                           Integer documentId,
                           Integer documentTransitId,
                           String documentRealName,
                           String documentRealNumber,
                           Date documentRealDate,
                           Date documentRealDateModify,
                           Integer progUserId) {
        this.documentRealId = documentRealId;
        this.documentId = documentId;
        this.documentTransitId = documentTransitId;
        this.documentRealName = documentRealName;
        this.documentRealNumber = documentRealNumber;
        this.documentRealDate = documentRealDate;
        this.documentRealDateModify = documentRealDateModify;
        this.progUserId = progUserId;
    }

    public Integer getDocumentRealId() {
        return documentRealId;
    }

    public void setDocumentRealId(Integer documentRealId) {
        this.documentRealId = documentRealId;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
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

    public Date getDocumentRealDate() {
        return documentRealDate;
    }

    public void setDocumentRealDate(Date documentRealDate) {
        this.documentRealDate = documentRealDate;
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
}
