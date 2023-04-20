package biz.spring.core.dto;

import biz.spring.core.model.Address;
import io.swagger.v3.oas.annotations.media.Schema;

public class AddressDTO {

    @Schema(description = "ИД адреса")
    private Integer addressId;

    @Schema(description = "ИД города")
    private Integer townId;

    @Schema(description = "Наименование города")
    private String townName;

    @Schema(description = "ИД улицы")
    private Integer streetId;

    @Schema(description = "Наименование улицы")
    private String streetName;

    @Schema(description = "Дом улицы")
    private String addressHouse;

    @Schema(description = "Литера дома")
    private String addressLitera;

    @Schema(description = "Корпус дома")
    private String addressCorpus;

    public AddressDTO() {
    }

    public AddressDTO(Integer addressId,
                      Integer townId,
                      Integer streetId,
                      String addressHouse,
                      String addressLitera,
                      String addressCorpus) {
        this.addressId = addressId;
        this.townId = townId;
        this.streetId = streetId;
        this.addressHouse = addressHouse;
        this.addressLitera = addressLitera;
        this.addressCorpus = addressCorpus;
    }

    public Address toEntity(){
        return toEntity(new Address());
    }

    public Address toEntity(Address entity){
        return entity;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
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
}
