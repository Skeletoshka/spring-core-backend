package biz.spring.core.model;

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

    @Id
    @Column(name = "people_id", nullable = false)
    @NotNull(message = "Поле \"ID пользователя\" не может быть NULL")
    private Integer peopleId;

    @Column(name = "people_name", nullable = false)
    @NotNull(message = "Поле \"Имя\" не может быть NULL")
    @Size(max = 20, message = "Поле \"Имя\" не может иметь более {max} символов")
    private String peopleName;
    
    @Column(name = "people_lastname", nullable = false)
    @NotNull(message = "Поле \"Фамиоия\" не может быть NULL")
    @Size(max = 20, message = "Поле \"Фамилия\" не может иметь более {max} символов")
    private String peopleLastName;
    
    @Column(name = "people_middlename", nullable = false)
    @NotNull(message = "Поле \"Отчество\" не может быть NULL")
    @Size(max = 20, message = "Поле \"Отчество\" не может иметь более {max} символов")
    private String peopleMiddleName;
    
    @Column(name = "people_datebirth", nullable = false)
    @NotNull(message = "Поле \"Дата рождения\" не может быть NULL")
    private Date peopleDatebirth;
    
    @Column(name = "capclass_id", nullable = false)
    @NotNull(message = "Поле \"ID класса\" не может быть NULL")
    private Integer capclassId;
    
    @Column(name = "people_email", nullable = false)
    @NotNull(message = "Поле \"Email\" не может быть NULL")
    @Size(max = 20, message = "Поле \"Фамилия\" не может иметь более {max} символов")
    private String peopleEmail;
    
    @Column(name = "people_phone", nullable = false)
    @Size(max = 14, message = "Поле \"Фамилия\" не может иметь более {max} символов")
    private String peoplePhone;
    
    @Column(name = "people_deleteflag", nullable = false)
    private Integer peopleDeleteFlag;
    
    @Column(name = "people_datedelete", nullable = false)
    private Date peopleDateDelete;

    public People() {
    }

    public People(Integer peopleId,
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
