package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.RequestPos;
import io.swagger.v3.oas.annotations.media.Schema;

public class RequestPosDTO {

    @Schema(description = "ИД позиции заявки")
    private Integer requestPosId;

    @Schema(description = "ИД заявки")
    private Integer requestId;

    @Schema(description = "Текст завки")
    private String requestPosText;

    @Schema(description = "ИД услуги")
    private Integer serviceId;

    @Schema(description = "Наименование услуги")
    private String serviceName;

    public RequestPosDTO() {
    }

    public RequestPosDTO(Integer requestPosId,
                         Integer requestId,
                         String requestPosText,
                         Integer serviceId) {
        this.requestPosId = requestPosId;
        this.requestId = requestId;
        this.requestPosText = requestPosText;
        this.serviceId = serviceId;
    }

    public RequestPos toEntity(){
        return toEntity(new RequestPos());
    }

    public RequestPos toEntity(RequestPos entity){
        entity.setRequestId(this.requestId);
        entity.setRequestPosId(this.requestPosId);
        entity.setServiceId(this.serviceId);
        entity.setRequestPosText(this.requestPosText);
        return entity;
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
