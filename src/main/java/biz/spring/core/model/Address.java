package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id", nullable = false)
    private Integer addressId;

    @Column(name = "town_id", nullable = false)
    @NotNull(message = "Поле \"ИД города\" не может быть пустым")
    private Integer townId;

    @Column(name = "street_id", nullable = false)
    @NotNull(message = "Поле \"ИД улицы\" не может быть пустым")
    private Integer streetId;

    @Column(name = "address_house", nullable = false)
    @Size(max = 10, message = "Поле \"Дом улицы\" не может иметь более {max} символов")
    @NotNull(message = "Поле \"Дом улицы\" не может быть пустым")
    private String addressHouse;

    @Column(name = "address_litera", nullable = false)
    @Size(max = 10, message = "Поле \"Литера дома\" не может иметь более {max} символов")
    private String addressLitera;

    @Column(name = "address_corpus", nullable = false)
    @Size(max = 10, message = "Поле \"Корпус дома\" не может иметь более {max} символов")
    private String addressCorpus;

    public Address() {
    }

    public Address(Integer addressId,
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

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
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
