package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "workgroup")
public class WorkGroup {
    @Id
    @Column(name = "workgroup_id", nullable = false)
    private Integer workGroupId;

    @Column(name = "workgroup_name", nullable = false)
    @Size(max = 100, message = "Поле \"Наименование учебной группы\" не может быть более {max} символов")
    @NotNull(message = "Поле \"Наименование программы обучения\" не может быть null")
    private String workGroupName;

    @Column(name = "direction_id", nullable = false)
    @NotNull(message = "Поле \"ИД направления\" не может быть null")
    private Integer directionId;

    @Column(name = "workgroup_desc", nullable = true)
    @Size(max = 255, message = "Поле \"Описание учебной группы\" не может быть более {max} символов")
    private String workGroupDesc;

    public WorkGroup(){
    }

    public WorkGroup(Integer workGroupId,
                     String workGroupName,
                     Integer directionId,
                     String workGroupDesc){
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
}
