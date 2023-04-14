package biz.spring.core.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class CapClassTypeDTO {

    @Schema(description = "ИД типа классификатора")
    private Integer capClassTypeId;

    @Schema(description = "Наименование типа классификатора")
    private String capClassTypeName;

    @Schema(description = "Описание типа классификатора")
    private String capClassTypeDesc;

    public CapClassTypeDTO() {
    }

    public CapClassTypeDTO(Integer capClassTypeId,
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