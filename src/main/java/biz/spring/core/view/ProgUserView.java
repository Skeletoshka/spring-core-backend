package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class ProgUserView {

    @Column(name = "proguser_id")
    @Schema(description = "ИД пользователя")
    private Integer progUserId;

    @Column(name = "proguser_name")
    @Schema(description = "Наименование пользователя")
    private String progUserName;

    @Column(name = "proguser_fullname")
    @Schema(description = "Полное наименование пользователя")
    private String progUserFullName;

    @Column(name = "proguser_webpassword")
    @Schema(description = "Пароль пользователя")
    private String progUserWebPassword;

    @Column(name = "proguser_active")
    @Schema(description = "Флаг активности пользователя")
    private Integer progUserActive;

    @Column(name = "worker_id")
    @Schema(description = "ИД человека")
    private Integer workerId;

    public ProgUserView() {
    }

    public ProgUserView(Integer progUserId,
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
