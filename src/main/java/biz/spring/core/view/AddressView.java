package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class AddressView {

    @Schema(description = "ИД адреса")
    @Column(name = "address_id")
    private Integer addressId;

    @Schema(description = "ИД города")
    @Column(name = "town_id")
    private Integer townId;

    @Schema(description = "Наименование города")
    @Column(name = "town_name")
    private String townName;

    @Schema(description = "ИД улицы")
    @Column(name = "street_id")
    private Integer streetId;

    @Schema(description = "Наименование улицы")
    @Column(name = "street_name")
    private String streetName;

    @Schema(description = "Дом улицы")
    @Column(name = "address_house")
    private String addressHouse;

    @Schema(description = "Литера дома")
    @Column(name = "addressLitera")
    private String addressLitera;

    @Schema(description = "Корпус дома")
    @Column(name = "address_corpus")
    private String addressCorpus;

    public AddressView() {
    }

    public AddressView(Integer addressId,
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
