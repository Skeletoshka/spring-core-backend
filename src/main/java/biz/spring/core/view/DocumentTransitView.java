package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class DocumentTransitView {

    @Column(name = "documenttransit_id")
    @Schema(description = "ИД статуса документа")
    private Integer documentTransitId;

    @Column(name = "documenttransit_name")
    @Schema(description = "Имя статуса документа")
    private String documentTransitName;

    @Column(name = "documenttype_id")
    @Schema(description = "Тип документа")
    private Integer documentTypeId;

    @Column(name = "documenttransit_number")
    @Schema(description = "Номер статуса")
    private Integer documentTransitNumber;

    @Column(name = "documenttransit_color")
    @Schema(description = "Цвет статуса")
    private Integer documentTransitColor;

    public DocumentTransitView() {
    }

    public DocumentTransitView(Integer documentTransitId,
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
