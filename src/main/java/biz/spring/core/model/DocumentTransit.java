package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "documenttransit")
public class DocumentTransit {

    @Id
    @Column(name = "documenttransit_id", nullable = false)
    private Integer documentTransitId;

    @Column(name = "documenttransit_name", nullable = false)
    @NotNull(message = "Поле \"Имя статуса документа\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Имя статуса документа\" не может иметь более {max} символов")
    private String documentTransitName;

    @Column(name = "documenttype_id", nullable = false)
    @NotNull(message = "Поле \"Тип документа\" не может быть пустым")
    private Integer documentTypeId;

    @Column(name = "documenttransit_number", nullable = false)
    @NotNull(message = "Поле \"Номер статуса\" не может быть пустым")
    private Integer documentTransitNumber;

    @Column(name = "documenttransit_color", nullable = false)
    @NotNull(message = "Поле \"Цвет статуса\" не может быть пустым")
    private Integer documentTransitColor;

    public DocumentTransit() {
    }

    public DocumentTransit(Integer documentTransitId,
                           String documentTransitName,
                           Integer documentTypeId,
                           Integer documentTransitNumber,
                           Integer documentTransitColor) {
        this.documentTransitId = documentTransitId;
        this.documentTransitName = documentTransitName;
        this.documentTypeId = documentTypeId;
        this.documentTransitNumber = documentTransitNumber;
        this.documentTransitColor = documentTransitColor;
    }

    public Integer getDocumentTransitId() {
        return documentTransitId;
    }

    public void setDocumentTransitId(Integer documentTransitId) {
        this.documentTransitId = documentTransitId;
    }

    public String getDocumentTransitName() {
        return documentTransitName;
    }

    public void setDocumentTransitName(String documentTransitName) {
        this.documentTransitName = documentTransitName;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public Integer getDocumentTransitNumber() {
        return documentTransitNumber;
    }

    public void setDocumentTransitNumber(Integer documentTransitNumber) {
        this.documentTransitNumber = documentTransitNumber;
    }

    public Integer getDocumentTransitColor() {
        return documentTransitColor;
    }

    public void setDocumentTransitColor(Integer documentTransitColor) {
        this.documentTransitColor = documentTransitColor;
    }
}
