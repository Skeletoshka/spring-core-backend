package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "people")
public class People {

    public static int CHILD_ID = 4;
    public static int PARENT_ID = 8;

    @Id
    @Column(name = "people_id", nullable = false)
    private Integer peopleId;

    @Column(name = "people_name", nullable = false)
    @NotNull(message = "Поле \"Имя\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Имя\" не может иметь более {max} символов")
    private String peopleName;
    
    @Column(name = "people_lastname", nullable = false)
    @NotNull(message = "Поле \"Фамиоия\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Фамилия\" не может иметь более {max} символов")
    private String peopleLastName;
    
    @Column(name = "people_middlename", nullable = false)
    @NotNull(message = "Поле \"Отчество\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Отчество\" не может иметь более {max} символов")
    private String peopleMiddleName;
    
    @Column(name = "people_DateBirth", nullable = false)
    @NotNull(message = "Поле \"Дата рождения\" не может быть пустым")
    private Date peopleDateBirth;
    
    @Column(name = "capclass_id", nullable = false)
    @NotNull(message = "Поле \"ID классификатора\" не может быть пустым")
    private Integer capClassId;
    
    @Column(name = "people_email", nullable = false)
    @NotNull(message = "Поле \"Email\" не может быть NULL")
    @Size(max = 255, message = "Поле \"Email\" не может иметь более {max} символов")
    private String peopleEmail;
    
    @Column(name = "people_phone", nullable = false)
    @Size(max = 50, message = "Поле \"Телефон\" не может иметь более {max} символов")
    private String peoplePhone;
    
    @Column(name = "people_deleteflag", nullable = false)
    private Integer peopleDeleteFlag;
    
    @Column(name = "people_datedelete", nullable = false)
    private Date peopleDateDelete;

    @Column(name = "company_id")
    private Integer companyId;

    public People() {
    }

    public People(Integer peopleId,
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
