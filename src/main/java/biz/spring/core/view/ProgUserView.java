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

    @Column(name = "people_id")
    @Schema(description = "ИД человека")
    private Integer peopleId;

    @Column(name = "people_name")
    @Schema(description = "Имя человека")
    private String peopleName;

    @Column(name = "people_lastname")
    @Schema(description = "Фамилия человека")
    private String peopleLastName;

    @Column(name = "people_middlename")
    @Schema(description = "Отчество человека")
    private String peopleMiddleName;

    public ProgUserView() {
    }

    public ProgUserView(Integer progUserId,
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

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleLastName() {
        return peopleLastName;
    }

    public void setPeopleLastName(String peopleLastName) {
        this.peopleLastName = peopleLastName;
    }

    public String getPeopleMiddleName() {
        return peopleMiddleName;
    }

    public void setPeopleMiddleName(String peopleMiddleName) {
        this.peopleMiddleName = peopleMiddleName;
    }
}
