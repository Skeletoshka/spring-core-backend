package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class RequestView {

    @Schema(description = "ИД заявки")
    @Column(name = "request_id")
    private Integer requestId;

    @Schema(description = "Имя заявки")
    @Column(name = "request_text")
    private String requestText;

    @Schema(description = "Имя документа")
    @Column(name = "documentreal_name")
    private String documentRealName;

    @Schema(description = "Номер документа")
    @Column(name = "documentreal_number")
    private String documentRealNumber;

    @Schema(description = "Дата документа")
    @Column(name = "documentreal_datecreate")
    private Date documentRealDateCreate;

    @Schema(description = "Ид пользователя")
    @Column(name = "proguser_id")
    private Integer progUserId;

    @Schema(description = "Имя пользователя")
    @Column(name = "proguser_name")
    private String progUserName;

    @Schema(description = "ИД статуса заявки")
    @Column(name = "documenttransit_id")
    private Integer documentTransitId;

    @Schema(description = "Имя статуса заявки")
    @Column(name = "documenttransit_name")
    private String documentTransitName;

    @Schema(description = "Цвет статуса заявки")
    @Column(name = "documenttransit_color")
    private Integer documentTransitColor;

    @Schema(description = "Имя услуги")
    @Column(name = "service_name")
    private String serviceName;

    @Schema(description = "ИД услуги")
    @Column(name = "service_id")
    private Integer serviceId;

    public RequestView() {
    }

    public RequestView(Integer requestId,
                       String requestText) {
        this.requestId = requestId;
        this.requestText = requestText;
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

    public String getProgUserName() {
        return progUserName;
    }

    public void setProgUserName(String progUserName) {
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
