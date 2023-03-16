package biz.spring.core.dto;

import biz.spring.core.model.ControlObject;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class ControlObjectRoleDTO {

    @Schema(description = "ИД роли")
    private Integer accessRoleId;

    @Schema(description = "Контроллируемые объекты, доступные роли")
    private List<ControlObject> controlObjects;

    public ControlObjectRoleDTO() {
    }

    public Integer getAccessRoleId() {
        return accessRoleId;
    }

    public void setAccessRoleId(Integer accessRoleId) {
        this.accessRoleId = accessRoleId;
    }

    public List<ControlObject> getControlObjects() {
        return controlObjects;
    }

    public void setControlObjects(List<ControlObject> controlObjects) {
        this.controlObjects = controlObjects;
    }
}
