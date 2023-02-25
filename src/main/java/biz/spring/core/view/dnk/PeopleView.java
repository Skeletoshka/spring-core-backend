package biz.spring.core.view.dnk;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class PeopleView {

    @Column(name = "people_id")
    private Integer peopleId;

    @Column(name = "people_name")
    private String peopleName;

    @Column(name = "people_lastname")
    private String peopleLastName;

    @Column(name = "people_middlename")
    private String peopleMiddleName;

    @Column(name = "people_datebirth")
    private Date peopleDatebirth;

    @Column(name = "capclass_id")
    private Integer capclassId;

    @Column(name = "people_email")
    private String peopleEmail;

    @Column(name = "people_phone")
    private String peoplePhone;

    @Column(name = "people_deleteflag")
    private Integer peopleDeleteFlag;

    @Column(name = "people_datedelete")
    private Date peopleDateDelete;

    public PeopleView() {
    }

    public PeopleView(Integer peopleId,
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
}

