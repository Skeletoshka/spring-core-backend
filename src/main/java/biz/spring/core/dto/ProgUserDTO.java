package biz.spring.core.dto;

import javax.persistence.Column;

public class ProgUserDTO {

    private Integer progUserId;

    private String progUserName;

    private String progUserFullName;

    private String progUserWebPassword;

    private Integer progUserActive;

    private Integer workerId;

    public ProgUserDTO() {
    }

    public ProgUserDTO(Integer progUserId,
                        String progUserName,
                        String progUserFullName,
                        String progUserWebPassword,
                        Integer progUserActive,
                        Integer workerId) {
        this.progUserId = progUserId;
        this.progUserName = progUserName;
        this.progUserFullName = progUserFullName;
        this.progUserWebPassword = progUserWebPassword;
        this.progUserActive = progUserActive;
        this.workerId = workerId;
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

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }
}
