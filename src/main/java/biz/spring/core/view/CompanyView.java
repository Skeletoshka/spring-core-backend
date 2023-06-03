package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class CompanyView {

    @Schema(description = "ИД компании")
    @Column(name = "company_id")
    private Integer companyId;

    @Schema(description = "Наименование компании")
    @Column(name = "company_name")
    private String companyName;

    @Schema(description = "ИД пользователя")
    @Column(name = "proguser_id")
    private Integer progUserId;

    @Schema(description = "Имя пользователя")
    @Column(name = "proguser_name")
    private String progUserName;

    @Schema(description = "ИД адреса")
    @Column(name = "address_id")
    private Integer addressId;

    @Schema(description = "Контактный телефон")
    @Column(name = "company_telephone")
    private String companyTelephone;

    @Schema(description = "Электронная почта")
    @Column(name = "company_email")
    private String companyEmail;

    @Schema(description = "ИД договора")
    @Column(name = "contract_id")
    private Integer contractId;

    @Schema(description = "Дата договора")
    @Column(name = "contract_date")
    private Date contractDate;

    @Schema(description = "Имя договора")
    @Column(name = "documentreal_name")
    private String documentRealName;

    public CompanyView() {
    }

    public CompanyView(Integer companyId,
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

    public String getProgUserName() {
        return progUserName;
    }

    public void setProgUserName(String progUserName) {
        this.progUserName = progUserName;
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
}
