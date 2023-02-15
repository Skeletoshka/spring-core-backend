package biz.spring.core.dto;

import biz.spring.core.model.AccessRole;
import biz.spring.core.model.People;

import java.util.Date;

public class PeopleDTO {

    private Integer peopleId;
    private String peopleName;
    private String peopleLastName;
    private String peopleMiddleName;
    private Date peopleDatebirth;
    private Integer capclassId;
    private String peopleEmail;
    private String peoplePhone;
    private Integer peopleDeleteFlag;
    private Date peopleDateDelete;

    public PeopleDTO() {
    }

    public PeopleDTO(Integer peopleId,
                  String peopleName,
                  String peopleLastName,
                  String peopleMiddleName,
                  Date peopleDatebirth,
                  Integer capclassId,
                  String peopleEmail,
                  String peoplePhone,
                  Integer peopleDeleteFlag,
                  Date peopleDateDelete
    ) {
        this.peopleId = peopleId;
        this.peopleName= peopleName;
        this.peopleLastName = peopleLastName;
        this.peopleMiddleName = peopleMiddleName;
        this.peopleDatebirth = peopleDatebirth;
        this.capclassId = capclassId;
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
    public Date getPeopleDatebirth() {
        return peopleDatebirth;
    }

    public void setPeopleDatebirth(Date peopleDatebirth) {
        this.peopleDatebirth = peopleDatebirth;
    }
    public Integer getCapClassId() {
        return capclassId;
    }

    public void setCapclassId(Integer capclassId) {
        this.capclassId = capclassId;
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

    public People toEntity(){
        return toEntity(new People());
    }
    public People toEntity(People people){
        people.setPeopleId(this.peopleId);
        people.setPeopleName(this.peopleName);
        people.setPeopleLastName(this.peopleLastName);
        people.setPeopleMiddleName(this.peopleMiddleName);
        people.setPeopleDatebirth(this.peopleDatebirth);
        people.setCapclassId(this.capclassId);
        people.setPeopleEmail(this.peopleEmail);
        people.setPeoplePhone(this.peoplePhone);
        people.setPeopleDeleteFlag(this.peopleDeleteFlag);
        people.setPeopleDateDelete(this.peopleDateDelete);
        return people;
    }
}