package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class CapClassTypeView {

    @Schema(description = "ИД типа классификатора")
    @Column(name = "capclasstype_id")
    private Integer capClassTypeId;

    @Schema(description = "Наименование типа классификатора")
    @Column(name = "capclasstype_name")
    private String capClassTypeName;

    @Schema(description = "Описание типа классификатора")
    @Column(name = "capclasstype_desc")
    private String capClassTypeDesc;

    public CapClassTypeView() {
    }

    public CapClassTypeView(Integer capClassTypeId,
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
