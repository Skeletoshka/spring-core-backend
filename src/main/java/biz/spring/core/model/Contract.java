package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_date", nullable = false)
    private Date contractDate;

    public Contract() {
    }

    public Contract(Integer contractId,
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
}
