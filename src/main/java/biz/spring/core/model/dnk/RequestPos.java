package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "requestpos")
public class RequestPos {
    @Id
    @Column(name = "requestpos_id", nullable = false)
    private Integer requestPosId;

    @Column(name = "request_id", nullable = false)
    @NotNull(message = "Поле \"Заявка\" не может быть пустым")
    private Integer requestId;

    @Column(name = "requestpos_text", nullable = false)
    @NotNull(message = "Поле \"Текст заявки\" не может быть пустым")
    private String requestPosText;

    @Column(name = "service_id", nullable = false)
    @NotNull(message = "Поле \"Услуга\" не может быть пустым")
    private Integer serviceId;

    public RequestPos() {
    }

    public RequestPos(Integer requestPosId,
                      Integer requestId,
                      String requestPosText,
                      Integer serviceId) {
        this.requestPosId = requestPosId;
        this.requestId = requestId;
        this.requestPosText = requestPosText;
        this.serviceId = serviceId;
    }

    public void setRequestPosId(Integer requestPosId) {
        this.requestPosId = requestPosId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public void setRequestPosText(String requestPosText) {
        this.requestPosText = requestPosText;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getRequestPosId() {
        return requestPosId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public String getRequestPosText() {
        return requestPosText;
    }

    public Integer getServiceId() {
        return serviceId;
    }
}
