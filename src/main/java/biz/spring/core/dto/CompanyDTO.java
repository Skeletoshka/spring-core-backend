package biz.spring.core.dto;

import biz.spring.core.model.Company;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class CompanyDTO {

    @Schema(description = "ИД компании")
    private Integer companyId;

    @Schema(description = "Наименование компании")
    private String companyName;

    @Schema(description = "ИД пользователя")
    private Integer progUserId;

    @Schema(description = "ИД адреса")
    private Integer addressId;

    @Schema(description = "Контактный телефон")
    private String companyTelephone;

    @Schema(description = "Электронная почта")
    private String companyEmail;

    @Schema(description = "ИД договора")
    private Integer contractId;

    @Schema(description = "Дата договора")
    private Date contractDate;

    @Schema(description = "Имя договора")
    private String documentRealName;

    @Schema(description = "Имя пользователя")
    private String progUserName;

    public CompanyDTO() {
    }

    public CompanyDTO(Integer companyId,
                      String companyName,
                      Integer progUserId,
                      Integer addressId,
                      String companyTelephone,
                      String companyEmail,
                      Integer contractId) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.progUserId = progUserId;
        this.addressId = addressId;
        this.companyTelephone = companyTelephone;
        this.companyEmail = companyEmail;
        this.contractId = contractId;
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

    public Integer getProgUserId() {
        return progUserId;
    }

    public void setProgUserId(Integer progUserId) {
        this.progUserId = progUserId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Company toEntity(){
        return toEntity(new Company());
    }

    public Company toEntity(Company company){
        company.setCompanyId(this.companyId);
        company.setCompanyName(this.companyName);
        company.setCompanyTelephone(this.companyTelephone);
        company.setCompanyEmail(this.companyEmail);
        company.setAddressId(this.addressId);
        company.setProgUserId(this.progUserId);
        company.setContractId(this.contractId);
        return company;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getDocumentRealName() {
        return documentRealName;
    }

    public void setDocumentRealName(String documentRealName) {
        this.documentRealName = documentRealName;
    }

    public String getProgUserName() {
        return progUserName;
    }

    public void setProgUserName(String progUserName) {
        this.progUserName = progUserName;
    }
}
