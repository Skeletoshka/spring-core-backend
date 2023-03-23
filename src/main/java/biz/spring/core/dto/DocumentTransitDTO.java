package biz.spring.core.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class DocumentTransitDTO {

    @Schema(description = "ИД статуса документа")
    private Integer documentTransitId;

    @Schema(description = "Имя статуса документа")
    private String documentTransitName;

    @Schema(description = "Тип документа")
    private Integer documentTypeId;

    @Schema(description = "Номер статуса")
    private Integer documentTransitNumber;

    @Schema(description = "Цвет статуса")
    private Integer documentTransitColor;

    public DocumentTransitDTO() {
    }

    public DocumentTransitDTO(Integer documentTransitId,
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
