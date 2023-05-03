package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class WorkGroupView {

    @Schema(description = "ИД учебной группы")
    @Column(name = "workgroup_id")
    private Integer workGroupId;

    @Schema(description = "Наименование учебной группы")
    @Column(name = "workgroup_name")
    private String workGroupName;

    @Schema(description = "ИД направления")
    @Column(name = "direction_id")
    private Integer directionId;

    @Schema(description = "ИД направления")
    @Column(name = "direction_name")
    private String directionName;

    @Schema(description = "Описание учебной группы")
    @Column(name = "workgroup_desc")
    private String workGroupDesc;

    public WorkGroupView(){
    }

    public WorkGroupView(Integer workGroupId,
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
}
