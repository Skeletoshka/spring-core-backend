package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class CompanyView {

    @Schema(name = "ИД компании")
    @Column(name = "company_id")
    private Integer companyId;

    @Schema(name = "Наименование компании")
    @Column(name = "company_name")
    private String companyName;

    @Schema(name = "ИД пользователя")
    @Column(name = "proguser_id")
    private Integer progUserId;

    @Schema(name = "ИД адреса")
    @Column(name = "address_id")
    private Integer addressId;

    @Schema(name = "Контактный телефон")
    @Column(name = "company_telephone")
    private String companyTelephone;

    @Schema(name = "Электронная почта")
    @Column(name = "company_email")
    private String companyEmail;

    public CompanyView() {
    }

    public CompanyView(Integer companyId,
                       String companyName,
                       Integer progUserId,
                       Integer addressId,
                       String companyTelephone,
                       String companyEmail) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.progUserId = progUserId;
        this.addressId = addressId;
        this.companyTelephone = companyTelephone;
        this.companyEmail = companyEmail;
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
}
