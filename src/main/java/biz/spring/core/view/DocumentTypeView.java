package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class DocumentTypeView {

    @Column(name = "documenttype_id")
    @Schema(description = "Тип документа")
    private Integer documentTypeId;

    @Column(name = "documenttype_name")
    @Schema(description = "Имя типа документа")
    private String documentTypeName;

    public DocumentTypeView() {
    }

    public DocumentTypeView(Integer documentTypeId,
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
