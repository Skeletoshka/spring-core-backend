package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "controlobject")
public class ControlObject {

    @Id
    @Column(name = "controlobject_id", nullable = false)
    private Integer controlObjectId;

    @Column(name = "controlobject_url", nullable = false)
    @NotNull(message = "Поле \"URL контроллируемого объекта\" не может быть NULL")
    @Size(max = 255, message = "Поле \"URL контроллируемого объекта\" не может иметь больше {max} символов")
    private String controlObjectUrl;

    @Column(name = "controlobject_name", nullable = false)
    @NotNull(message = "Поле \"Наименование контроллируемого объекта\" не может быть NULL")
    @Size(max = 255, message = "Поле \"Наименование контроллируемого объекта\" не может иметь больше {max} символов")
    private String controlObjectName;

    public ControlObject() {
    }

    public ControlObject(Integer controlObjectId,
                         String controlObjectUrl,
                         String controlObjectName) {
        this.controlObjectId = controlObjectId;
        this.controlObjectUrl = controlObjectUrl;
        this.controlObjectName = controlObjectName;
    }

    public Integer getControlObjectId() {
        return controlObjectId;
    }

    public void setControlObjectId(Integer controlObjectId) {
        this.controlObjectId = controlObjectId;
    }

    public String getControlObjectUrl() {
        return controlObjectUrl;
    }

    public void setControlObjectUrl(String controlObjectUrl) {
        this.controlObjectUrl = controlObjectUrl;
    }

    public String getControlObjectName() {
        return controlObjectName;
    }

    public void setControlObjectName(String controlObjectName) {
        this.controlObjectName = controlObjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControlObject that = (ControlObject) o;
        return controlObjectUrl.equals(that.controlObjectUrl) &&
                Objects.equals(controlObjectName, that.controlObjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlObjectUrl, controlObjectName);
    }
}
