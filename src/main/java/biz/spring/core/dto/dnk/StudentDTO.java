package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.People;
import biz.spring.core.model.dnk.Student;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class StudentDTO{

    @Schema(description = "ИД ученика")
    private Integer studentId;

    @Schema(description = "ИД человека")
    private Integer peopleId;

    @Schema(description = "Класс ученика")
    private String studentClass;

    @Schema(description = "Муниципальный район ученика")
    private String studentMun;

    @Schema(description = "Договор")
    private Integer contractId;

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

    @Schema(description = "ИД компании")
    private Integer companyId;

    @Schema(description = "Наименование компании")
    private String companyName;

    public StudentDTO() {
    }

    public StudentDTO(Integer studentId,
                      String studentClass,
                      String studentMun,
                      Integer contractId) {
        this.studentId = studentId;
        this.studentClass = studentClass;
        this.studentMun = studentMun;
        this.contractId = contractId;
    }

    public Student toEntity(){
        return toEntity(new Student());
    }

    public Student toEntity(Student entity){
        entity.setContractId(this.contractId);
        entity.setStudentClass(this.studentClass);
        entity.setStudentMun(this.studentMun);
        entity.setStudentId(this.studentId);
        return entity;
    }

    public People toPeople(){
        return toPeople(new People());
    }

    public People toPeople(People entity){
        entity.setCompanyId(this.companyId);
        entity.setPeopleId(this.studentId);
        entity.setPeopleDeleteFlag(this.peopleDeleteFlag);
        entity.setPeopleEmail(this.peopleEmail);
        entity.setPeopleDateBirth(this.peopleDateBirth);
        entity.setPeopleDateDelete(this.peopleDateDelete);
        entity.setPeopleName(this.peopleName);
        entity.setPeopleLastName(this.peopleLastName);
        entity.setPeopleMiddleName(this.peopleMiddleName);
        entity.setCapClassId(People.CHILD_ID);
        entity.setPeoplePhone(this.peoplePhone);
        return entity;
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

    public Integer getCapClassName() {
        return capClassName;
    }

    public void setCapClassName(Integer capClassName) {
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

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }
}
