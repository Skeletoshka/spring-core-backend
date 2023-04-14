package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.People;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class PeopleDTO {

    @Schema(description = "ИД человека")
    private Integer peopleId;

    @Schema(description = "Имя")
    private String peopleName;

    @Schema(description = "Фамилия")
    private String peopleLastName;

    @Schema(description = "Отчество")
    private String peopleMiddleName;

    @Schema(description = "Дата рождения")
    private Date peopleDateBirth;

    @Schema(description = "ИД класса человека")
    private Integer capClassId;

    @Schema(description = "Наименование класса человека")
    private Integer capClassName;

    @Schema(description = "Электронная почта")
    private String peopleEmail;

    @Schema(description = "Номер телефона")
    private String peoplePhone;

    @Schema(description = "Флаг удаления")
    private Integer peopleDeleteFlag;

    @Schema(description = "Дата удаления")
    private Date peopleDateDelete;

    public PeopleDTO() {
    }

    public PeopleDTO(Integer peopleId,
                  String peopleName,
                  String peopleLastName,
                  String peopleMiddleName,
                  Date peopleDateBirth,
                  Integer capClassId,
                  String peopleEmail,
                  String peoplePhone,
                  Integer peopleDeleteFlag,
                  Date peopleDateDelete
    ) {
        this.peopleId = peopleId;
        this.peopleName= peopleName;
        this.peopleLastName = peopleLastName;
        this.peopleMiddleName = peopleMiddleName;
        this.peopleDateBirth = peopleDateBirth;
        this.capClassId = capClassId;
        this.peopleEmail = peopleEmail;
        this.peoplePhone = peoplePhone;
        this.peopleDeleteFlag = peopleDeleteFlag;
        this.peopleDateDelete = peopleDateDelete;

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
    public String getPeopleEmail() {
        return peopleEmail;
    }

    public void setPeopleEmail(String peopleEmail) {
        this.peopleEmail = peopleEmail;
    }
    public String getPeoplePhone() {
        return peoplePhone;
    }

    public void setPeoplePhone(String peoplePhone) {
        this.peoplePhone = peoplePhone;
    }
    public Integer getPeopleDeleteFlag() {
        return peopleDeleteFlag;
    }

    public void setPeopleDeleteFlag(Integer peopleDeleteFlag) {
        this.peopleDeleteFlag = peopleDeleteFlag;
    }
    public Date getPeopleDateDelete() {
        return peopleDateDelete;
    }

    public void setPeopleDateDelete(Date peopleDateDelete) {
        this.peopleDateDelete = peopleDateDelete;
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

    public Date getPeopleDateBirth() {
        return peopleDateBirth;
    }

    public void setPeopleDateBirth(Date peopleDateBirth) {
        this.peopleDateBirth = peopleDateBirth;
    }

    public Integer getCapClassId() {
        return capClassId;
    }

    public void setCapClassId(Integer capClassId) {
        this.capClassId = capClassId;
    }

    public Integer getCapClassName() {
        return capClassName;
    }

    public void setCapClassName(Integer capClassName) {
        this.capClassName = capClassName;
    }

    public People toEntity(){
        return toEntity(new People());
    }
    public People toEntity(People people){
        people.setPeopleId(this.peopleId);
        people.setPeopleName(this.peopleName);
        people.setPeopleLastName(this.peopleLastName);
        people.setPeopleMiddleName(this.peopleMiddleName);
        people.setPeopleDateBirth(this.peopleDateBirth);
        people.setCapClassId(this.capClassId);
        people.setPeopleEmail(this.peopleEmail);
        people.setPeoplePhone(this.peoplePhone);
        people.setPeopleDeleteFlag(this.peopleDeleteFlag);
        people.setPeopleDateDelete(this.peopleDateDelete);
        return people;
    }
}