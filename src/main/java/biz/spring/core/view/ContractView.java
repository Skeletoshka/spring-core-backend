package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class ContractView {

    @Schema(name = "ИД договора")
    @Column(name = "contractId")
    private Integer contractId;

    @Column(name = "contract_date")
    @Schema(name = "Дата договора")
    private Date contractDate;

    @Schema(name = "Номер договора")
    @Column(name = "documentreal_number")
    private Date documentRealNumber;

    @Schema(name = "Имя договора")
    @Column(name = "documentreal_name")
    private Date documentRealName;

    @Schema(name = "ИД типа документа")
    @Column(name = "documenttype_id")
    private Integer documentTypeId;

    @Schema(name = "Наименование типа документа")
    @Column(name = "documenttype_name")
    private String documentTypeName;

    public ContractView() {
    }

    public ContractView(Integer contractId,
                        Date contractDate) {
        this.contractId = contractId;
        this.contractDate = contractDate;
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

    public Date getDocumentRealNumber() {
        return documentRealNumber;
    }

    public void setDocumentRealNumber(Date documentRealNumber) {
        this.documentRealNumber = documentRealNumber;
    }

    public Date getDocumentRealName() {
        return documentRealName;
    }

    public void setDocumentRealName(Date documentRealName) {
        this.documentRealName = documentRealName;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }
}
