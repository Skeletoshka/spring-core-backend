package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "accessrole")
public class AccessRole {

    @Id
    @Column(name = "accessrole_id", nullable = false)
    @NotNull(message = "Поле \"ИД роли\" не может быть NULL")
    private Integer accessRoleId;

    @Column(name = "accessrole_name", nullable = false)
    @NotNull(message = "Поле \"Наименование роли\" не может быть NULL")
    @Size(max = 50, message = "Поле \"Наименование роли\" не может иметь более {max} символов")
    private String accessRoleName;

    @Column(name = "accessrole_fullname")
    @Size(max = 100, message = "Поле \"Полное наименование роли\" не может иметь более {max} символов")
    private String accessRoleFullName;

    public AccessRole() {
    }

    public AccessRole(Integer accessRoleId,
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
}
