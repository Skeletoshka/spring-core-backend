package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "proguser")
public class ProgUser {

    @Id
    @Column(name = "proguser_id", nullable = false)
    @NotNull(message = "Поле \"ИД пользователя\" не может быть null")
    private Integer progUserId;

    @Column(name = "proguser_name", nullable = false)
    @Size(max = 50, message = "Поле \"Наименование пользователя\" не может быть более {max} символов")
    @NotNull(message = "Поле \"Наименование пользователя\" не может быть null")
    private String progUserName;

    @Column(name = "proguser_fullname", nullable = true)
    @Size(max = 100, message = "Поле \"Полное наименование пользователя\" не может быть более {max} символов")
    @NotNull(message = "Поле \"Полное наименование пользователя\" не может быть null")
    private String progUserFullName;

    @Column(name = "proguser_password", nullable = false)
    @Size(max = 255, message = "Поле \"Пароль пользователя\" не может быть более {max} символов")
    @NotNull(message = "Поле \"Пароль пользователя\" не может быть null")
    private String progUserWebPassword;

    @Column(name = "proguser_active", nullable = false)
    @NotNull(message = "Поле \"Активный пользователь\" не может быть null")
    private Integer progUserActive;

    @Column(name = "worker_id", nullable = false)
    @NotNull(message = "Поле \"ИД сотрудника\" не может быть null")
    private Integer workerId;

    public ProgUser() {
    }

    public ProgUser(Integer progUserId,
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
