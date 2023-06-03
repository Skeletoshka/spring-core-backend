package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class PeopleView {

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

    @Column(name = "people_datebirth")
    @Schema(description = "Дата рождения человека")
    private Date peopleDateBirth;

    @Column(name = "capclass_id")
    @Schema(description = "Классификатор человека")
    private Integer capClassId;

    @Column(name = "capclass_name")
    @Schema(description = "Наименование классификатора")
    private String capClassName;

    @Column(name = "people_email")
    @Schema(description = "Электронный адресс человека")
    private String peopleEmail;

    @Column(name = "people_phone")
    @Schema(description = "Номер телефона человека")
    private String peoplePhone;

    @Column(name = "people_deleteflag")
    @Schema(description = "Флаг удаления человека")
    private Integer peopleDeleteFlag;

    @Column(name = "people_datedelete")
    @Schema(description = "Дата удаления человека")
    private Date peopleDateDelete;

    @Column(name = "company_id")
    @Schema(description = "ИД компании")
    private Integer companyId;

    @Column(name = "company_name")
    @Schema(description = "Наименование компании")
    private Integer companyName;

    @Column(name = "parent_name")
    @Schema(description = "Имя родителя")
    private String parentName;

    @Column(name = "parent_lastname")
    @Schema(description = "Фамилия родителя")
    private String parentLastName;

    @Column(name = "parent_middlename")
    @Schema(description = "Отчество родителя")
    private String parentMiddleName;

    public PeopleView() {
    }

    public PeopleView(Integer peopleId,
                  String peopleName,
                  String peopleLastName,
                  String peopleMiddleName,
                  Date peopleDateBirth,
                  Integer capClassId,
                  String peopleEmail,
                  String peoplePhone,
                  Integer peopleDeleteFlag,
                  Date peopleDateDelete,
                  Integer companyId
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
        this.companyId = companyId;
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

    public String getCapClassName() {
        return capClassName;
    }

    public void setCapClassName(String capClassName) {
        this.capClassName = capClassName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Integer companyName) {
        this.companyName = companyName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public String getParentMiddleName() {
        return parentMiddleName;
    }

    public void setParentMiddleName(String parentMiddleName) {
        this.parentMiddleName = parentMiddleName;
    }
}

