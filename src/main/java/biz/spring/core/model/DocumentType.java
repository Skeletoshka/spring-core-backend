package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "documenttype")
public class DocumentType {

    @Id
    @Column(name = "documenttype_id", nullable = false)
    private Integer documentTypeId;

    @Column(name = "documenttype_name", nullable = false)
    @NotNull(message = "Поле \"Имя типа документа\" не может быть пустым")
    @Size(max = 255, message = "Поле \"Имя типа документа\" не может иметь более {max} символов")
    private String documentTypeName;

    public DocumentType() {
    }

    public DocumentType(Integer documentTypeId,
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
