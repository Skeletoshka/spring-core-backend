package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class CapClassView {

    @Column(name = "capclass_id")
    @Schema(description = "ИД классификатора")
    private Integer capClassId;

    @Column(name = "capclass_name")
    @Schema(description = "Наименование классификатора")
    private String capClassName;

    @Column(name = "capclass_desc")
    @Schema(description = "Описание классификатора")
    private String capClassDesc;

    @Column(name = "capclasstype_id")
    @Schema(description = "ИД типа классификатора")
    private Integer capClassTypeId;

    @Column(name = "capclasstype_name")
    @Schema(description = "Наименование типа классификатора")
    private Integer capClassTypeName;

    public CapClassView() {
    }

    public CapClassView(Integer capClassId,
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

    public Integer getCapClassTypeName() {
        return capClassTypeName;
    }

    public void setCapClassTypeName(Integer capClassTypeName) {
        this.capClassTypeName = capClassTypeName;
    }
}
