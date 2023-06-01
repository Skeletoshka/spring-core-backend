package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class AppendixView {
    @Column(name = "appendix_id")
    @Schema(description = "ИД вложения")
    private Integer appendixId;

    @Column(name = "appendix_name")
    @Schema(description = "Наименование вложения")
    private String appendixName;

    @Column(name = "appendix_path")
    @Schema(description = "Путь вложения")
    private String appendixPath;

    @Schema(description = "Дата создания")
    @Column(name = "documentreal_datecreate")
    private Date documentRealDateCreate;

    @Schema(description = "Дата модификации")
    @Column(name = "documentreal_datemodify")
    private Date documentRealDateModify;

    @Schema(description = "Имя пользователя")
    @Column(name = "proguser_name")
    private String progUserName;

    @Schema(description = "Имя типа документа")
    @Column(name = "documenttype_name")
    private String documentTypeName;

    public AppendixView(){
    }

    public AppendixView(Integer appendixId,
                       String appendixName,
                       String appendixPath) {
        this.appendixId = appendixId;
        this.appendixName = appendixName;
        this.appendixPath = appendixPath;
    }

    public Integer getAppendixId() {
        return appendixId;
    }

    public void setAppendixId(Integer appendixId) {
        this.appendixId = appendixId;
    }

    public String getAppendixName() {
        return appendixName;
    }

    public void setAppendixName(String appendixName) {
        this.appendixName = appendixName;
    }

    public String getAppendixPath() {
        return appendixPath;
    }

    public void setAppendixPath(String appendixPath) {
        this.appendixPath = appendixPath;
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

    public String getProgUserName() {
        return progUserName;
    }

    public void setProgUserName(String progUserName) {
        this.progUserName = progUserName;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }
}
