package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class DocumentRealView {

    @Column(name = "documentreal_id")
    @Schema(description = "ИД документа")
    private Integer documentRealId;

    @Column(name = "documenttype_id")
    @Schema(description = "Типа документа")
    private Integer documentTypeId;

    @Column(name = "documenttransit_id")
    @Schema(description = "Статус документа")
    private Integer documentTransitId;

    @Column(name = "documentreal_name")
    @Schema(description = "Имя документа")
    private String documentRealName;

    @Column(name = "documentreal_number")
    @Schema(description = "Номер документа")
    private String documentRealNumber;

    @Column(name = "documentreal_date")
    @Schema(description = "Дата создания документа")
    private Date documentRealDate;

    @Column(name = "documentreal_datemodify")
    @Schema(description = "Дата модификации документа")
    private Date documentRealDateModify;

    @Column(name = "proguser_id")
    @Schema(description = "ИД пользователя")
    private Integer progUserId;

    public DocumentRealView() {
    }

    public DocumentRealView(Integer documentRealId,
                            Integer documentTypeId,
                            Integer documentTransitId,
                            String documentRealName,
                            String documentRealNumber,
                            Date documentRealDate,
                            Date documentRealDateModify,
                            Integer progUserId) {
        this.documentRealId = documentRealId;
        this.documentTypeId = documentTypeId;
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
