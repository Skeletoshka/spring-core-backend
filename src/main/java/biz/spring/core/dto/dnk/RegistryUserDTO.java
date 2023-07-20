package biz.spring.core.dto.dnk;

import biz.spring.core.model.Company;
import biz.spring.core.model.ProgUser;
import biz.spring.core.model.dnk.People;
import biz.spring.core.model.dnk.Student;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class RegistryUserDTO {

    public static final int PEOPLE_ROLE = 12;
    public static final int CHILD_ROLE = 13;
    public static final int COMPANY_ROLE = 14;

    @Schema(description = "ИД роли пользователя")
    private Integer accessRoleId;

    @Schema(description = "Имя пользователя")
    private String progUserName;

    @Schema(description = "Пароль пользователя")
    private String progUserPassword;

    @Schema(description = "Электронная почта пользователя")
    private String progUserEmail;

    @Schema(description = "Имя родителя")
    private String peopleName;

    @Schema(description = "Отчество родителя")
    private String peopleMiddleName;

    @Schema(description = "Фамилия родителя")
    private String peopleLastName;

    @Schema(description = "Номер телефона родителя")
    private String peopleTelephone;

    @Schema(description = "Дата рождения родителя")
    private Date peopleDateBirth;

    @Schema(description = "Имя ребенка")
    private String childName;

    @Schema(description = "Отчество ребенка")
    private String childMiddleName;

    @Schema(description = "Фамилия ребенка")
    private String childLastName;

    @Schema(description = "Номер телефона ребенка")
    private String childTelephone;

    @Schema(description = "Дата рождения ребенка")
    private Date childDateBirth;

    @Schema(description = "Школа ребенка")
    private Integer companyId;

    @Schema(description = "Муниципальное образование ребенка")
    private String studentMun;

    @Schema(description = "Класс ребенка")
    private String studentClass;

    @Schema(description = "Название школы")
    private String companyName;

    @Schema(description = "Электронный адрес школы")
    private String companyEmail;

    @Schema(description = "Номер телефона школы")
    private String companyTelephone;

    public RegistryUserDTO() {
    }

    public Integer getAccessRoleId() {
        return accessRoleId;
    }

    public void setAccessRoleId(Integer accessRoleId) {
        this.accessRoleId = accessRoleId;
    }

    public String getProgUserName() {
        return progUserName;
    }

    public void setProgUserName(String progUserName) {
        this.progUserName = progUserName;
    }

    public String getProgUserPassword() {
        return progUserPassword;
    }

    public void setProgUserPassword(String progUserPassword) {
        this.progUserPassword = progUserPassword;
    }

    public String getProgUserEmail() {
        return progUserEmail;
    }

    public void setProgUserEmail(String progUserEmail) {
        this.progUserEmail = progUserEmail;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleMiddleName() {
        return peopleMiddleName;
    }

    public void setPeopleMiddleName(String peopleMiddleName) {
        this.peopleMiddleName = peopleMiddleName;
    }

    public String getPeopleLastName() {
        return peopleLastName;
    }

    public void setPeopleLastName(String peopleLastName) {
        this.peopleLastName = peopleLastName;
    }

    public String getPeopleTelephone() {
        return peopleTelephone;
    }

    public void setPeopleTelephone(String peopleTelephone) {
        this.peopleTelephone = peopleTelephone;
    }

    public Date getPeopleDateBirth() {
        return peopleDateBirth;
    }

    public void setPeopleDateBirth(Date peopleDateBirth) {
        this.peopleDateBirth = peopleDateBirth;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildMiddleName() {
        return childMiddleName;
    }

    public void setChildMiddleName(String childMiddleName) {
        this.childMiddleName = childMiddleName;
    }

    public String getChildLastName() {
        return childLastName;
    }

    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }

    public String getChildTelephone() {
        return childTelephone;
    }

    public void setChildTelephone(String childTelephone) {
        this.childTelephone = childTelephone;
    }

    public Date getChildDateBirth() {
        return childDateBirth;
    }

    public void setChildDateBirth(Date childDateBirth) {
        this.childDateBirth = childDateBirth;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getStudentMun() {
        return studentMun;
    }

    public void setStudentMun(String studentMun) {
        this.studentMun = studentMun;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public People toParent(){
        return toParent(new People());
    }

    public People toParent(People people){
        people.setPeopleName(this.peopleName);
        people.setPeopleLastName(this.peopleLastName);
        people.setPeopleMiddleName(this.childMiddleName);
        people.setPeopleDateBirth(this.peopleDateBirth);
        people.setCapClassId(People.PARENT_ID);
        people.setPeopleDeleteFlag(0);
        people.setPeoplePhone(this.peopleTelephone);
        people.setPeopleEmail(this.progUserEmail);
        return people;
    }

    public People toChild(){
        return toChild(new People());
    }

    public People toChild(People people){
        people.setPeopleName(this.childName);
        people.setPeopleLastName(this.childLastName);
        people.setPeopleMiddleName(this.childMiddleName);
        people.setPeopleDateBirth(this.childDateBirth);
        people.setCapClassId(People.CHILD_ID);
        people.setPeopleDeleteFlag(0);
        people.setPeoplePhone(this.childTelephone);
        people.setPeopleEmail(this.progUserEmail);
        people.setCompanyId(this.companyId);
        return people;
    }

    public Student toStudent(){
        return toStudent(new Student());
    }

    public Student toStudent(Student student){
        student.setStudentClass(this.studentClass);
        student.setStudentMun(this.studentMun);
        student.setContractId(0);
        return student;
    }

    public Company toCompany(){
        return toCompany(new Company());
    }

    public Company toCompany(Company company){
        company.setCompanyEmail(this.companyEmail);
        company.setCompanyName(this.companyName);
        company.setCompanyTelephone(this.companyTelephone);
        company.setContractId(0);
        return company;
    }

    public ProgUser toProgUser(){
        return toProgUser(new ProgUser());
    }

    public ProgUser toProgUser(ProgUser progUser){
        progUser.setProgUserActive(1);
        progUser.setProgUserFullName(this.progUserEmail);
        progUser.setProgUserName(this.progUserName);
        progUser.setProgUserPassword(this.progUserPassword);
        return progUser;
    }
}
