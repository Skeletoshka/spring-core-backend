package biz.spring.core.dto;

import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.Appendix;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class AppendixDTO {

    @Schema(description = "ИД вложения")
    private Integer appendixId;

    @Schema(description = "Наименование вложения")
    private String appendixName;

    @Schema(description = "Путь вложения")
    private String appendixPath;

    @Schema(description = "Дата создания")
    private Date documentRealDateCreate;

    @Schema(description = "Дата модификации")
    private Date documentRealDateModify;

    @Schema(description = "Имя пользователя")
    private String progUserName;

    public AppendixDTO(){
    }

    public AppendixDTO(Integer appendixId,
                    String appendixName,
                    String appendixPath) {
        this.appendixId = appendixId;
        this.appendixName = appendixName;
        this.appendixPath = appendixPath;
    }

    public Appendix toEntity(){
        return toEntity(new Appendix());
    }

    public Appendix toEntity(Appendix appendix){
        appendix.setAppendixId(this.appendixId);
        appendix.setAppendixName(this.appendixName);
        appendix.setAppendixPath(this.appendixPath);
        return appendix;
    }

    public DocumentReal toDocumentReal(){
        return toDocumentReal(new DocumentReal());
    }

    public DocumentReal toDocumentReal(DocumentReal entity){
        entity.setDocumentRealId(this.appendixId);
        entity.setDocumentRealNumber(String.valueOf(this.appendixId));
        return entity;
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
}
