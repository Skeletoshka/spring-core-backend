package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "capclass")
public class CapClass {

    @Id
    @Column(name = "capclass_id", nullable = false)
    private Integer capClassId;

    @Column(name = "capclass_name", nullable = false)
    @NotNull(message = "Поле \"Имя классификатора\" не может быть NULL")
    @Size(max = 50, message = "Поле \"Имя классификатора\" не может иметь более {max} символов")
    private String capClassName;

    @Column(name = "capclass_desc", nullable = false)
    @NotNull(message = "Поле \"Описание классификатора\" не может быть NULL")
    @Size(max = 100, message = "Поле \"Описание классификатора\" не может иметь более {max} символов")
    private String capClassDesc;

    @Column(name = "capclasstype_id", nullable = false)
    @NotNull(message = "Поле \"Тип классификатора\" не может быть NULL")
    private Integer capClassTypeId;

    public CapClass() {
    }

    public CapClass(Integer capClassId,
                    String capClassName,
                    String capClassDesc,
                    Integer capClassTypeId) {
        this.capClassId = capClassId;
        this.capClassName = capClassName;
        this.capClassDesc = capClassDesc;
        this.capClassTypeId = capClassTypeId;
    }

    public Integer getCapClassId() {
        return capClassId;
    }

    public void setCapClassId(Integer capClassId) {
        this.capClassId = capClassId;
    }

    public String getCapClassName() {
        return capClassName;
    }

    public void setCapClassName(String capClassName) {
        this.capClassName = capClassName;
    }

    public String getCapClassDesc() {
        return capClassDesc;
    }

    public void setCapClassDesc(String capClassDesc) {
        this.capClassDesc = capClassDesc;
    }

    public Integer getCapClassTypeId() {
        return capClassTypeId;
    }

    public void setCapClassTypeId(Integer capClassTypeId) {
        this.capClassTypeId = capClassTypeId;
    }
}
