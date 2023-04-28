package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.Service;
import io.swagger.v3.oas.annotations.media.Schema;

public class ServiceDTO {

    @Schema(description = "ИД услуги")
    private Integer serviceId;

    @Schema(name = "Наименование услуги")
    private String serviceName;

    @Schema(name = "Описание услуги")
    private String serviceDesc;

    public ServiceDTO() {
    }

    public ServiceDTO(Integer serviceId,
                      String serviceName,
                      String serviceDesc) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDesc = serviceDesc;
    }

    public Service toEntity(){
        return toEntity(new Service());
    }

    public Service toEntity(Service entity){
        entity.setServiceId(this.serviceId);
        entity.setServiceName(this.serviceName);
        entity.setServiceDesc(this.serviceDesc);
        return entity;
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

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }
}
