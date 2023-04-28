package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class ServiceView {

    @Schema(description = "ИД услуги")
    @Column(name = "service_id")
    private Integer serviceId;

    @Schema(name = "Наименование услуги")
    @Column(name = "service_name")
    private String serviceName;

    @Schema(name = "Описание услуги")
    @Column(name = "service_desc")
    private String serviceDesc;

    public ServiceView() {
    }

    public ServiceView(Integer serviceId,
                       String serviceName,
                       String serviceDesc) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDesc = serviceDesc;
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
