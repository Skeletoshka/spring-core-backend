package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class StudentView{

    @Schema(description = "ИД ученика")
    @Column(name = "student_id")
    private Integer studentId;

    @Schema(description = "Класс ученика")
    @Column(name = "student_class")
    private String studentClass;

    @Schema(description = "Муниципальный район ученика")
    @Column(name = "student_mun")
    private String studentMun;

    @Schema(description = "Договор")
    @Column(name = "contract_id")
    private Integer contractId;

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
    private String companyName;

    @Column(name = "parent_name")
    @Schema(description = "Имя родителя")
    private String parentName;

    @Column(name = "parent_lastname")
    @Schema(description = "Фамилия родителя")
    private String parentLastName;

    @Column(name = "parent_middlename")
    @Schema(description = "Отчество родителя")
    private String parentMiddleName;

    @Column(name = "documentreal_name")
    @Schema(description = "Документ о зачислени")
    private String documentRealName;

    public StudentView() {
    }

    public StudentView(Integer studentId,
                       String studentClass,
                       String studentMun,
                       Integer contractId) {
        this.studentId = studentId;
        this.studentClass = studentClass;
        this.studentMun = studentMun;
        this.contractId = contractId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentMun() {
        return studentMun;
    }

    public void setStudentMun(String studentMun) {
        this.studentMun = studentMun;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
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

    public String getCapClassName() {
        return capClassName;
    }

    public void setCapClassName(String capClassName) {
        this.capClassName = capClassName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
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

    public String getDocumentRealName() {
        return documentRealName;
    }

    public void setDocumentRealName(String documentRealName) {
        this.documentRealName = documentRealName;
    }
}
