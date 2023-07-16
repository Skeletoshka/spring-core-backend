package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class AccessRoleView {

    @Column(name = "accessrole_id")
    @Schema(description = "ИД роли")
    private Integer accessRoleId;

    @Column(name = "accessrole_name")
    @Schema(description = "Наименование роли")
    private String accessRoleName;

    @Column(name = "accessrole_fullname")
    @Schema(description = "Полное наименование роли")
    private String accessRoleFullName;

    @Column(name = "accessrole_visible")
    @Schema(description = "Видимость роли")
    private Integer accessRoleVisible;

    public AccessRoleView() {
    }

    public AccessRoleView(Integer accessRoleId,
                          String accessRoleName,
                          String accessRoleFullName,
                          Integer accessRoleVisible) {
        this.accessRoleId = accessRoleId;
        this.accessRoleName = accessRoleName;
        this.accessRoleFullName = accessRoleFullName;
        this.accessRoleVisible = accessRoleVisible;
    }

    public AccessRoleView(Integer accessRoleId,
                          String accessRoleName,
                          String accessRoleFullName) {
        this.accessRoleId = accessRoleId;
        this.accessRoleName = accessRoleName;
        this.accessRoleFullName = accessRoleFullName;
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

    public Integer getAccessRoleVisible() {
        return accessRoleVisible;
    }

    public void setAccessRoleVisible(Integer accessRoleVisible) {
        this.accessRoleVisible = accessRoleVisible;
    }
}
