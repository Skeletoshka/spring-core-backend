package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import java.util.Date;

public class ActivityView {

    @Schema(description = "ИД события")
    @Column(name = "activity_id")
    private Integer activityId;

    @Schema(description = "ИД адреса")
    @Column(name = "address_id")
    private Integer addressId;

    @Schema(description = "Город")
    @Column(name = "town_name")
    private String townName;

    @Schema(description = "Улица")
    @Column(name = "street_name")
    private String streetName;

    @Schema(description = "Дом адреса")
    @Column(name = "address_house")
    private String addressHouse;

    @Schema(description = "Литера дома")
    @Column(name = "address_litera")
    private String addressLitera;

    @Schema(description = "Корпус дома")
    @Column(name = "address_corpus")
    private String addressCorpus;

    @Schema(description = "ИД направления")
    @Column(name = "direction_id")
    private Integer directionId;

    @Schema(description = "Наименование направления")
    @Column(name = "direction_name")
    private String directionName;

    @Schema(description = "ИД партнёра")
    @Column(name = "company_id")
    private Integer companyId;

    @Schema(description = "Наименование партнёра")
    @Column(name = "company_name")
    private String companyName;

    @Schema(description = "Наименование события")
    @Column(name = "activity_name")
    private String activityName;

    @Schema(description = "Дата события")
    @Column(name = "activity_date")
    private Date activityDate;

    @Schema(description = "ИД типа события")
    @Column(name = "capclass_id")
    private Integer capClassId;

    @Schema(description = "Наименование классификатора")
    @Column(name = "capclass_name")
    private Integer capClassName;

    public ActivityView() {
    }

    public ActivityView(Integer activityId,
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

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAddressHouse() {
        return addressHouse;
    }

    public void setAddressHouse(String addressHouse) {
        this.addressHouse = addressHouse;
    }

    public String getAddressLitera() {
        return addressLitera;
    }

    public void setAddressLitera(String addressLitera) {
        this.addressLitera = addressLitera;
    }

    public String getAddressCorpus() {
        return addressCorpus;
    }

    public void setAddressCorpus(String addressCorpus) {
        this.addressCorpus = addressCorpus;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
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

    public Integer getCapClassName() {
        return capClassName;
    }

    public void setCapClassName(Integer capClassName) {
        this.capClassName = capClassName;
    }
}
