package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "capclasstype")
public class CapClassType {
    @Id
    @Column(name = "capclasstype_id", nullable = false)
    private Integer capClassTypeId;

    @Column(name = "capclasstype_name", nullable = false)
    @Size(max=50, message = "Поле \"Наименование типа классификатора\" не может иметь более {max} символов")
    private String capClassTypeName;

    @Column(name = "capclasstype_desc", nullable = false)
    @Size(max=100, message = "Поле \"Описание типа классификатора\" не может иметь более {max} символов")
    private String capClassTypeDesc;

    public CapClassType() {
    }

    public CapClassType(Integer capClassTypeId,
                        String capClassTypeName,
                        String capClassTypeDesc) {
        this.capClassTypeId = capClassTypeId;
        this.capClassTypeName = capClassTypeName;
        this.capClassTypeDesc = capClassTypeDesc;
    }

    public Integer getCapClassTypeId() {
        return capClassTypeId;
    }

    public void setCapClassTypeId(Integer capClassTypeId) {
        this.capClassTypeId = capClassTypeId;
    }

    public String getCapClassTypeName() {
        return capClassTypeName;
    }

    public void setCapClassTypeName(String capClassTypeName) {
        this.capClassTypeName = capClassTypeName;
    }

    public String getCapClassTypeDesc() {
        return capClassTypeDesc;
    }

    public void setCapClassTypeDesc(String capClassTypeDesc) {
        this.capClassTypeDesc = capClassTypeDesc;
    }
}
