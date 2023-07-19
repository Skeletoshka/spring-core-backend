package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class ReportView {

    @Column(name = "studyprogram_id")
    @Schema(description = "ИД программы обучения")
    private Integer studyProgramId;

    @Column(name = "studyprogram_name")
    @Schema(description = "Наименование программы обучения")
    private String studyProgramName;

    @Column(name = "workgroup_id")
    @Schema(description = "ИД учебной группы")
    private Integer workGroupId;

    @Column(name = "workgroup_name")
    @Schema(description = "Наименование учебной группы")
    private String workGroupName;

    @Column(name = "people_name")
    @Schema(description = "Имя ученика")
    private String peopleName;

    @Column(name = "people_lastname")
    @Schema(description = "Фамилия ученика")
    private String peopleLastName;

    @Column(name = "people_middlename")
    @Schema(description = "Отчество ученика")
    private String peopleMiddleName;

    @Column(name = "people_datebirth")
    @Schema(description = "Дата рождения ученика")
    private Date peopleDateBirth;

    @Column(name = "documentreal_datecreate")
    @Schema(description = "Дата зачисления")
    private Date peopleDateStart;

    @Column(name = "company_id")
    @Schema(description = "ИД партнёра")
    private Integer companyId;

    @Column(name = "company_name")
    @Schema(description = "Наименование партнёра")
    private String companyName;

    @Column(name = "student_class")
    @Schema(description = "Класс ученика")
    private String studentClass;

    @Column(name = "documentreal_number")
    @Schema(description = "Номер договора")
    private String documentRealNumber;

    @Column(name = "contract_id")
    @Schema(description = "ИД договора")
    private Integer contractId;

    @Column(name = "contract_date")
    @Schema(description = "Дата договора")
    private Date contractDate;

    @Column(name = "parent_id")
    @Schema(description = "ИД родителя")
    private Integer parentId;

    @Column(name = "parent_name")
    @Schema(description = "Имя родителя")
    private String parentName;

    @Column(name = "parent_lastname")
    @Schema(description = "Фамилия родителя")
    private String parentLastName;

    @Column(name = "parent_middlename")
    @Schema(description = "Отчество родителя")
    private String parentMiddleName;

    @Column(name = "parent_email")
    @Schema(description = "Электронный адресс родителей")
    private String parentEmail;

    @Column(name = "row_id")
    @Schema(description = "Номер строки")
    private Long rowId;

    public ReportView() {
    }

    public ReportView(Integer studyProgramId,
                      String studyProgramName,
                      Integer workGroupId,
                      String workGroupName,
                      String peopleName,
                      String peopleLastName,
                      String peopleMiddleName,
                      Date peopleDateBirth,
                      Date peopleDateStart,
                      Integer companyId,
                      String companyName,
                      String studentClass,
                      String documentRealNumber,
                      Integer contractId,
                      Date contractDate,
                      String parentName,
                      String parentLastName,
                      String parentMiddleName,
                      String parentEmail) {
        this.studyProgramId = studyProgramId;
        this.studyProgramName = studyProgramName;
        this.workGroupId = workGroupId;
        this.workGroupName = workGroupName;
        this.peopleName = peopleName;
        this.peopleLastName = peopleLastName;
        this.peopleMiddleName = peopleMiddleName;
        this.peopleDateBirth = peopleDateBirth;
        this.peopleDateStart = peopleDateStart;
        this.companyId = companyId;
        this.companyName = companyName;
        this.studentClass = studentClass;
        this.documentRealNumber = documentRealNumber;
        this.contractId = contractId;
        this.contractDate = contractDate;
        this.parentName = parentName;
        this.parentLastName = parentLastName;
        this.parentMiddleName = parentMiddleName;
        this.parentEmail = parentEmail;
    }

    public Integer getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(Integer studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public String getStudyProgramName() {
        return studyProgramName;
    }

    public void setStudyProgramName(String studyProgramName) {
        this.studyProgramName = studyProgramName;
    }

    public Integer getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(Integer workGroupId) {
        this.workGroupId = workGroupId;
    }

    public String getWorkGroupName() {
        return workGroupName;
    }

    public void setWorkGroupName(String workGroupName) {
        this.workGroupName = workGroupName;
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

    public Date getPeopleDateStart() {
        return peopleDateStart;
    }

    public void setPeopleDateStart(Date peopleDateStart) {
        this.peopleDateStart = peopleDateStart;
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

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getDocumentRealNumber() {
        return documentRealNumber;
    }

    public void setDocumentRealNumber(String documentRealNumber) {
        this.documentRealNumber = documentRealNumber;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
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

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
