package biz.spring.core.dto;

import biz.spring.core.model.ProgUser;
import biz.spring.core.view.AccessRoleView;

import javax.persistence.Column;
import java.util.List;

public class ProgUserDTO {

    private Integer progUserId;

    private String progUserName;

    private String progUserFullName;

    private String progUserWebPassword;

    private Integer progUserActive;

    private Integer peopleId;

    private List<AccessRoleView> accessRoleViews;

    public ProgUserDTO() {
    }

    public ProgUserDTO(Integer progUserId,
                        String progUserName,
                        String progUserFullName,
                        String progUserWebPassword,
                        Integer progUserActive,
                        Integer peopleId) {
        this.progUserId = progUserId;
        this.progUserName = progUserName;
        this.progUserFullName = progUserFullName;
        this.progUserWebPassword = progUserWebPassword;
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

    public String getProgUserWebPassword() {
        return progUserWebPassword;
    }

    public void setProgUserWebPassword(String progUserWebPassword) {
        this.progUserWebPassword = progUserWebPassword;
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

    public void setPeopleId(Integer workerId) {
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
        entity.setProgUserWebPassword(this.progUserWebPassword);
        entity.setProgUserActive(this.progUserActive);
        return entity;
    }
}
