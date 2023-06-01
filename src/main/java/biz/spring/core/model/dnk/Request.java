package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "request")
public class Request {

    public static final int DOCUMENT_STATUS = 2;
    public static final int DOCUMENT_DRAFT = 4;
    public static final int DOCUMENT_SEND = 5;
    public static final int DOCUMENT_SUBMIT = 6;
    public static final int DOCUMENT_REJECTION = 7;

    @Id
    @Column(name = "request_id", nullable = false)
    private Integer requestId;

    @Column(name = "request_text", nullable = false)
    @NotNull(message = "Поле \"Текст заявки\" не может быть пустым")
    @Size(max = 255, message = "Поле \"Текст заявки\" не может иметь более {max} символов")
    private String requestText;

    @Column(name = "service_id", nullable = false)
    @NotNull(message = "Поле \"ИД услуги\" не может быть пустым")
    private Integer serviceId;

    public Request() {
    }

    public Request(Integer requestId,
                   String requestText,
                   Integer serviceId) {
        this.requestId = requestId;
        this.requestText = requestText;
        this.serviceId = serviceId;
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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
