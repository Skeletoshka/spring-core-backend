package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.Activity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class ActivityDTO {

    @Schema(description = "ИД события")
    private Integer activityId;

    @Schema(description = "ИД адреса")
    private Integer addressId;

    @Schema(description = "Город")
    private String townName;

    @Schema(description = "Улица")
    private String streetName;

    @Schema(description = "Дом адреса")
    private String addressHouse;

    @Schema(description = "Литера дома")
    private String addressLitera;

    @Schema(description = "Корпус дома")
    private String addressCorpus;

    @Schema(description = "ИД направления")
    private Integer directionId;

    @Schema(description = "Наименование направления")
    private String directionName;

    @Schema(description = "ИД партнёра")
    private Integer companyId;

    @Schema(description = "Наименование партнёра")
    private String companyName;

    @Schema(description = "Наименование события")
    private String activityName;

    @Schema(description = "Дата события")
    private Date activityDate;

    @Schema(description = "ИД типа события")
    private Integer capClassId;

    @Schema(description = "Наименование классификатора")
    private Integer capClassName;

    public ActivityDTO() {
    }

    public ActivityDTO(Integer activityId,
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

    public Activity toEntity(){
        return toEntity(new Activity());
    }

    public Activity toEntity(Activity entity){
        entity.setActivityId(this.activityId);
        entity.setActivityDate(this.activityDate);
        entity.setActivityName(this.activityName);
        entity.setAddressId(this.addressId);
        entity.setCompanyId(this.companyId);
        entity.setCapClassId(this.capClassId);
        entity.setDirectionId(this.directionId);
        return entity;
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

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCapClassName() {
        return capClassName;
    }

    public void setCapClassName(Integer capClassName) {
        this.capClassName = capClassName;
    }
}
