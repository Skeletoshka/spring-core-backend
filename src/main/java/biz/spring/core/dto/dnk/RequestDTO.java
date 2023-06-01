package biz.spring.core.dto.dnk;

import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.dnk.Request;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class RequestDTO {

    @Schema(description = "ИД заявки")
    private Integer requestId;

    @Schema(description = "Текст заявки")
    private String requestText;

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

    @Schema(description = "Имя услуги")
    private String serviceName;

    @Schema(description = "ИД услуги")
    private Integer serviceId;

    public RequestDTO() {
    }

    public RequestDTO(Integer requestId,
                      String requestText) {
        this.requestId = requestId;
        this.requestText = requestText;
    }

    public Request toEntity(){
        return toEntity(new Request());
    }

    public Request toEntity(Request entity){
        entity.setRequestId(this.requestId);
        entity.setRequestText(this.requestText);
        entity.setServiceId(this.serviceId);
        return entity;
    }

    public DocumentReal toDocumentReal(){
        return toDocumentReal(new DocumentReal());
    }

    public DocumentReal toDocumentReal(DocumentReal documentReal){
        documentReal.setDocumentRealId(this.requestId);
        documentReal.setDocumentRealNumber(String.valueOf(this.requestId));
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

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
