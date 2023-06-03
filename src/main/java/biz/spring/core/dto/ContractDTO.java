package biz.spring.core.dto;

import biz.spring.core.model.Appendix;
import biz.spring.core.model.Contract;
import biz.spring.core.model.DocumentReal;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class ContractDTO {
    @Schema(name = "ИД договора")
    private Integer contractId;

    @Schema(name = "Дата договора")
    private Date contractDate;

    @Schema(name = "Номер договора")
    private String documentRealNumber;

    @Schema(name = "Имя договора")
    private String documentRealName;

    @Schema(name = "ИД типа документа")
    private Integer documentTypeId;

    @Schema(name = "Наименование типа документа")
    private String documentTypeName;

    @Schema(name = "Имя документа")
    private String appendixName;

    @Schema(name = "Путь к документу")
    private String appendixPath;

    public ContractDTO() {
    }

    public ContractDTO(Integer contractId,
                       Date contractDate) {
        this.contractId = contractId;
        this.contractDate = contractDate;
    }

    public Appendix toAppendix(){
        return toAppendix(new Appendix());
    }

    public Appendix toAppendix(Appendix appendix){
        appendix.setAppendixId(this.contractId);
        appendix.setAppendixName(this.appendixName.concat(this.appendixPath.substring(this.appendixPath.lastIndexOf("."))));
        appendix.setAppendixPath(this.appendixPath);
        return appendix;
    }

    public DocumentReal toDocumentReal(){
        return toDocumentReal(new DocumentReal());
    }

    public DocumentReal toDocumentReal(DocumentReal entity){
        entity.setDocumentRealId(this.contractId);
        entity.setDocumentRealNumber(this.documentRealNumber);
        entity.setDocumentTypeId(this.documentTypeId);
        return entity;
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

    public String getDocumentRealNumber() {
        return documentRealNumber;
    }

    public void setDocumentRealNumber(String documentRealNumber) {
        this.documentRealNumber = documentRealNumber;
    }

    public String getDocumentRealName() {
        return documentRealName;
    }

    public void setDocumentRealName(String documentRealName) {
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

    public String getAppendixName() {
        return appendixName;
    }

    public void setAppendixName(String appendixName) {
        this.appendixName = appendixName;
    }

    public String getAppendixPath() {
        return appendixPath;
    }

    public void setAppendixPath(String appendixPath) {
        this.appendixPath = appendixPath;
    }
}
