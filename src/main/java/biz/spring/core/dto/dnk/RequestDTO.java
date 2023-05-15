package biz.spring.core.dto.dnk;

import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.dnk.Request;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class RequestDTO {

    @Schema(description = "ИД заявки")
    private Integer requestId;

    @Schema(description = "Имя заявки")
    private String requestName;

    @Schema(description = "Имя документа")
    private String documentRealName;

    @Schema(description = "Номер документа")
    private String documentRealNumber;

    @Schema(description = "Дата документа")
    private Date documentRealDateCreate;

    @Schema(description = "Ид пользователя")
    private Integer progUserId;

    @Schema(description = "Имя пользователя")
    private Integer progUserName;

    @Schema(description = "ИД статуса заявки")
    private Integer documentTransitId;

    @Schema(description = "Имя статуса заявки")
    private String documentTransitName;

    @Schema(description = "Цвет статуса заявки")
    private Integer documentTransitColor;

    public RequestDTO() {
    }

    public RequestDTO(Integer requestId,
                      String requestName) {
        this.requestId = requestId;
        this.requestName = requestName;
    }

    public Request toEntity(){
        return toEntity(new Request());
    }

    public Request toEntity(Request entity){
        entity.setRequestId(this.requestId);
        entity.setRequestName(this.requestName);
        return entity;
    }

    public DocumentReal toDocumentReal(){
        return toDocumentReal(new DocumentReal());
    }

    public DocumentReal toDocumentReal(DocumentReal documentReal){
        documentReal.setDocumentRealId(this.requestId);
        documentReal.setDocumentRealNumber(this.requestName);
        documentReal.setDocumentTransitId(this.documentTransitId);
        documentReal.setDocumentTypeId(Request.DOCUMENT_STATUS);
        return documentReal;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
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

    public Date getDocumentRealDateCreate() {
        return documentRealDateCreate;
    }

    public void setDocumentRealDateCreate(Date documentRealDateCreate) {
        this.documentRealDateCreate = documentRealDateCreate;
    }

    public Integer getProgUserId() {
        return progUserId;
    }

    public void setProgUserId(Integer progUserId) {
        this.progUserId = progUserId;
    }

    public Integer getProgUserName() {
        return progUserName;
    }

    public void setProgUserName(Integer progUserName) {
        this.progUserName = progUserName;
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

    public Integer getDocumentTransitColor() {
        return documentTransitColor;
    }

    public void setDocumentTransitColor(Integer documentTransitColor) {
        this.documentTransitColor = documentTransitColor;
    }
}
