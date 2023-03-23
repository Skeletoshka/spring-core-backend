package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "documentreal")
public class DocumentReal {

    @Id
    @Column(name = "documentreal_id", nullable = false)
    @NotNull(message = "Поле \"ИД документа\" не может быть пустым")
    private Integer documentRealId;

    @Column(name = "documenttype_id", nullable = false)
    @NotNull(message = "Поле \"Типа документа\" не может быть пустым")
    private Integer documentTypeId;

    @Column(name = "documenttransit_id")
    private Integer documentTransitId;

    @Column(name = "documentreal_name", nullable = false)
    @NotNull(message = "Поле \"Имя документа\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Имя документа\" не может иметь больше {max} символов")
    private String documentRealName;

    @Column(name = "documentreal_number", nullable = false)
    @NotNull(message = "Поле \"Номер документа\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Номер документа\" не может иметь больше {max} символов")
    private String documentRealNumber;

    @Column(name = "documentreal_date", nullable = false)
    @NotNull(message = "Поле \"Дата создания документа\" не может быть пустым")
    private Date documentRealDate;

    @Column(name = "documentreal_datemodify", nullable = false)
    @NotNull(message = "Поле \"Дата модификации документа\" не может быть пустым")
    private Date documentRealDateModify;

    @Column(name = "proguser_id", nullable = false)
    @NotNull(message = "Поле \"ИД пользователя\" не может быть пустым")
    private Integer progUserId;

    public DocumentReal() {
    }

    public DocumentReal(Integer documentRealId,
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
