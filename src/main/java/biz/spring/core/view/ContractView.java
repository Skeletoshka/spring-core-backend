package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class ContractView {

    @Schema(name = "ИД договора")
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_date")
    @Schema(name = "Дата договора")
    private Date contractDate;

    @Schema(name = "Номер договора")
    @Column(name = "documentreal_number")
    private String documentRealNumber;

    @Schema(name = "Имя договора")
    @Column(name = "documentreal_name")
    private String documentRealName;

    @Schema(name = "ИД типа документа")
    @Column(name = "documenttype_id")
    private Integer documentTypeId;

    @Schema(name = "Наименование типа документа")
    @Column(name = "documenttype_name")
    private String documentTypeName;

    @Schema(name = "Путь к документу")
    @Column(name = "appendix_path")
    private String appendixPath;

    @Schema(name = "Имя документа")
    @Column(name = "appendix_name")
    private String appendixName;

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

    public String getAppendixPath() {
        return appendixPath;
    }

    public void setAppendixPath(String appendixPath) {
        this.appendixPath = appendixPath;
    }

    public String getAppendixName() {
        return appendixName;
    }

    public void setAppendixName(String appendixName) {
        this.appendixName = appendixName;
    }
}
