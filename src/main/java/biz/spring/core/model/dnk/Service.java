package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @Column(name = "service_id", nullable = false)
    private Integer serviceId;

    @Column(name = "service_name", nullable = false)
    @NotNull(message = "Поле \"Наименование услуги\" не может быть пустым")
    @Size(max = 255, message = "Поле \"Наименование услуни\" не может иметь более {max} символов")
    private String serviceName;

    @Column(name = "service_desc", nullable = true)
    @Size(max = 255, message = "Поле \"Описание услуги\" не может иметь более {max} символов")
    private String serviceDesc;

    public Service() {
    }

    public Service(Integer serviceId,
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
