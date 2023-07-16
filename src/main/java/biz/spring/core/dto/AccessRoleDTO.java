package biz.spring.core.dto;

import biz.spring.core.model.AccessRole;
import io.swagger.v3.oas.annotations.media.Schema;

public class AccessRoleDTO {

    @Schema(description = "ИД роли")
    private Integer accessRoleId;

    @Schema(description = "Наименование роли")
    private String accessRoleName;

    @Schema(description = "Полное наименование роли")
    private String accessRoleFullName;

    @Schema(description = "Видимость роли")
    private Integer accessRoleVisible;

    public AccessRoleDTO() {
    }

    public AccessRoleDTO(Integer accessRoleId,
                         String accessRoleName,
                         String accessRoleFullName,
                         Integer accessRoleVisible) {
        this.accessRoleId = accessRoleId;
        this.accessRoleName = accessRoleName;
        this.accessRoleFullName = accessRoleFullName;
        this.accessRoleVisible = accessRoleVisible;
    }

    public Integer getAccessRoleId() {
        return accessRoleId;
    }

    public void setAccessRoleId(Integer accessRoleId) {
        this.accessRoleId = accessRoleId;
    }

    public String getAccessRoleName() {
        return accessRoleName;
    }

    public void setAccessRoleName(String accessRoleName) {
        this.accessRoleName = accessRoleName;
    }

    public String getAccessRoleFullName() {
        return accessRoleFullName;
    }

    public void setAccessRoleFullName(String accessRoleFullName) {
        this.accessRoleFullName = accessRoleFullName;
    }

    public AccessRole toEntity(){
        return toEntity(new AccessRole());
    }

    public AccessRole toEntity(AccessRole accessRole){
        accessRole.setAccessRoleId(this.accessRoleId);
        accessRole.setAccessRoleName(this.accessRoleName);
        accessRole.setAccessRoleFullName(this.accessRoleFullName);
        accessRole.setAccessRoleVisible(this.accessRoleVisible);
        return accessRole;
    }

    public Integer getAccessRoleVisible() {
        return accessRoleVisible;
    }

    public void setAccessRoleVisible(Integer accessRoleVisible) {
        this.accessRoleVisible = accessRoleVisible;
    }
}
