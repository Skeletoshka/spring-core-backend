package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @Column(name = "activity_id", nullable = false)
    private Integer activityId;

    @Column(name = "address_id", nullable = false)
    @NotNull(message = "Поле \"Адрес\" не может быть пустым")
    private Integer addressId;

    @Column(name = "direction_id", nullable = false)
    @NotNull(message = "Поле \"Направление\" не может быть пустым")
    private Integer directionId;

    @Column(name = "company_id", nullable = true)
    private Integer companyId;

    @Column(name = "activity_name", nullable = false)
    @Size(max = 255, message = "Поле \"Наименование события\" не может иметь более {max} символов")
    @NotNull(message = "Поле \"Наименование события\" не может быть пустым")
    private String activityName;

    @Column(name = "activity_date", nullable = false)
    @NotNull(message = "Поле \"Дата события\" не может быть пустым")
    private Date activityDate;

    @Column(name = "capclass_id", nullable = false)
    @NotNull(message = "Поле \"Тип события\" не может быть пустым")
    private Integer capClassId;

    public Activity() {
    }

    public Activity(Integer activityId,
                    Integer addressId,
                    Integer directionId,
                    Integer companyId,
                    String activityName,
                    Date activityDate,
                    Integer capClassId) {
        this.activityId = activityId;
        this.addressId = addressId;
        this.directionId = directionId;
        this.companyId = companyId;
        this.activityName = activityName;
        this.activityDate = activityDate;
        this.capClassId = capClassId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public Integer getCapClassId() {
        return capClassId;
    }

    public void setCapClassId(Integer capClassId) {
        this.capClassId = capClassId;
    }
}
