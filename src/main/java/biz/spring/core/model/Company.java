package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "company_id", nullable = false)
    private Integer companyId;

    @Column(name = "company_name", nullable = false)
    @Size(max = 255, message = "Поле \"Наименование компании\" не может иметь более {max} символов")
    @NotNull(message = "Поле \"Наименование компании\" не может быть пустым")
    private String companyName;

    @Column(name = "proguser_id", nullable = false)
    private Integer progUserId;

    @Column(name = "address_id", nullable = false)
    private Integer addressId;

    @Column(name = "company_telephone")
    @Size(max = 20, message = "Поле \"Телефон компании\" не может иметь более {max} символов")
    private String companyTelephone;

    @Column(name = "company_email")
    @Size(max = 50, message = "Поле \"Электронный адрес\" не может быть более {max} символов")
    private String companyEmail;

    @Column(name = "contract_id", nullable = false)
    @NotNull(message = "Поле \"Договор\" не может быть пустым")
    private Integer contractId;

    public Company() {
    }

    public Company(Integer companyId,
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
}
