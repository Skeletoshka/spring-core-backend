package biz.spring.core.dto;

import biz.spring.core.model.ProgUser;
import biz.spring.core.view.AccessRoleView;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.List;

public class ProgUserDTO {

    @Schema(description = "ИД пользователя")
    private Integer progUserId;

    @Schema(description = "Наименование пользователя")
    private String progUserName;

    @Schema(description = "Полное наименование пользователя")
    private String progUserFullName;

    @Schema(description = "Пароль пользователя")
    private String progUserPassword;

    @Schema(description = "Флаг активности пользователя")
    private Integer progUserActive;

    @Schema(description = "ИД человека")
    private Integer peopleId;

    @Schema(description = "Список ролей пользователя")
    private List<AccessRoleView> accessRoleViews;

    public ProgUserDTO() {
    }

    public ProgUserDTO(Integer progUserId,
                        String progUserName,
                        String progUserFullName,
                        String progUserPassword,
                        Integer progUserActive,
                        Integer peopleId) {
        this.progUserId = progUserId;
        this.progUserName = progUserName;
        this.progUserFullName = progUserFullName;
        this.progUserPassword = progUserPassword;
        this.progUserActive = progUserActive;
        this.peopleId = peopleId;
    }

    public Integer getProgUserId() {
        return progUserId;
    }

    public void setProgUserId(Integer progUserId) {
        this.progUserId = progUserId;
    }

    public String getProgUserName() {
        return progUserName;
    }

    public void setProgUserName(String progUserName) {
        this.progUserName = progUserName;
    }

    public String getProgUserFullName() {
        return progUserFullName;
    }

    public void setProgUserFullName(String progUserFullName) {
        this.progUserFullName = progUserFullName;
    }

    public String getProgUserPassword() {
        return progUserPassword;
    }

    public void setProgUserPassword(String progUserPassword) {
        this.progUserPassword = progUserPassword;
    }

    public Integer getProgUserActive() {
        return progUserActive;
    }

    public void setProgUserActive(Integer progUserActive) {
        this.progUserActive = progUserActive;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public List<AccessRoleView> getAccessRoleViews() {
        return accessRoleViews;
    }

    public void setAccessRoleViews(List<AccessRoleView> accessRoleViews) {
        this.accessRoleViews = accessRoleViews;
    }

    public ProgUser toEntity(){
        return toEntity(new ProgUser());
    }

    public ProgUser toEntity(ProgUser entity){
        entity.setProgUserId(this.progUserId);
        entity.setProgUserName(this.progUserName);
        entity.setProgUserFullName(this.progUserFullName);
        entity.setPeopleId(this.peopleId);
        entity.setProgUserPassword(this.progUserPassword);
        entity.setProgUserActive(this.progUserActive);
        return entity;
    }
}
