package biz.spring.core.dto;

import biz.spring.core.model.Contract;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class ContractDTO {
    @Schema(name = "ИД договора")
    private Integer contractId;

    @Schema(name = "Дата договора")
    private Date contractDate;

    @Schema(name = "Номер договора")
    private Date documentRealNumber;

    @Schema(name = "Имя договора")
    private Date documentRealName;

    @Schema(name = "ИД типа документа")
    private Integer documentTypeId;

    @Schema(name = "Наименование типа документа")
    private String documentTypeName;

    public ContractDTO() {
    }

    public ContractDTO(Integer contractId,
                       Date contractDate) {
        this.contractId = contractId;
        this.contractDate = contractDate;
    }

    public Contract toEntity(){
        return toEntity(new Contract());
    }

    public Contract toEntity(Contract entity){
        entity.setContractId(this.contractId);
        entity.setContractDate(this.contractDate);
        return entity;
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
