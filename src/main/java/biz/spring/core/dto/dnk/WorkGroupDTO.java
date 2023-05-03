package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.WorkGroup;
import io.swagger.v3.oas.annotations.media.Schema;

public class WorkGroupDTO {

    @Schema(description = "ИД учебной группы")
    private Integer workGroupId;

    @Schema(description = "Наименование учебной группы")
    private String workGroupName;

    @Schema(description = "ИД направления")
    private Integer directionId;

    @Schema(description = "Описание учебной группы")
    private String workGroupDesc;

    @Schema(description = "ИД направления")
    private String directionName;

    public WorkGroupDTO() {
    }

    public WorkGroupDTO(Integer workGroupId,
                        String workGroupName,
                        Integer directionId,
                        String workGroupDesc) {
        this.workGroupId = workGroupId;
        this.workGroupName = workGroupName;
        this.directionId = directionId;
        this.workGroupDesc = workGroupDesc;
    }

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
    }

    public String getWorkGroupName() {
        return workGroupName;
    }

    public void setWorkGroupName(String workGroupName) {
        this.workGroupName = workGroupName;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public String getWorkGroupDesc() {
        return workGroupDesc;
    }

    public void setWorkGroupDesc(String workGroupDesc) {
        this.workGroupDesc = workGroupDesc;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public WorkGroup toEntity() { return  toEntity(new WorkGroup()); }

    public WorkGroup toEntity(WorkGroup entity){
        entity.setWorkGroupId(this.workGroupId);
        entity.setWorkGroupName(this.workGroupName);
        entity.setDirectionId(this.directionId);
        entity.setWorkGroupDesc(this.workGroupDesc);
        return entity;
    }
}
