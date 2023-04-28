package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class RequestPosView {

    @Schema(description = "ИД позиции заявки")
    @Column(name = "requestpos_id")
    private Integer requestPosId;

    @Schema(description = "ИД заявки")
    @Column(name = "request_id")
    private Integer requestId;

    @Schema(description = "Текст завки")
    @Column(name = "requestpos_text")
    private String requestPosText;

    @Schema(description = "ИД услуги")
    @Column(name = "service_id")
    private Integer serviceId;

    @Schema(description = "Наименование услуги")
    @Column(name = "service_name")
    private String serviceName;

    public RequestPosView() {
    }

    public RequestPosView(Integer requestPosId,
                          Integer requestId,
                          String requestPosText,
                          Integer serviceId) {
        this.requestPosId = requestPosId;
        this.requestId = requestId;
        this.requestPosText = requestPosText;
        this.serviceId = serviceId;
    }

    public Integer getRequestPosId() {
        return requestPosId;
    }

    public void setRequestPosId(Integer requestPosId) {
        this.requestPosId = requestPosId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getRequestPosText() {
        return requestPosText;
    }

    public void setRequestPosText(String requestPosText) {
        this.requestPosText = requestPosText;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
