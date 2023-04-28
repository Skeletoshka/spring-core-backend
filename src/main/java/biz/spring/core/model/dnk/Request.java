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

    @Id
    @Column(name = "request_id", nullable = false)
    private Integer requestId;

    @Column(name = "request_name", nullable = false)
    @NotNull(message = "Поле \"Имя заявки\" не может быть пустым")
    @Size(max = 255, message = "Поле \"Имя заявки\" не может иметь более {max} символов")
    private String requestName;

    public Request() {
    }

    public Request(Integer requestId,
                   String requestName) {
        this.requestId = requestId;
        this.requestName = requestName;
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
}
