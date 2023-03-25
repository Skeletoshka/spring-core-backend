package biz.spring.core.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class DocumentTypeDTO {

    @Schema(description = "Тип документа")
    private Integer documentTypeId;

    @Schema(description = "Имя типа документа")
    private String documentTypeName;

    public DocumentTypeDTO() {
    }

    public DocumentTypeDTO(Integer documentTypeId,
                       String documentTypeName) {
        this.documentTypeId = documentTypeId;
        this.documentTypeName = documentTypeName;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }
}
