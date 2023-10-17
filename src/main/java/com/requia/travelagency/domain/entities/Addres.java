package com.requia.travelagency.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_addres")
public class Addres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addresId;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Long getAddresId() {
        return addresId;
    }

    public void setAddresId(Long addresId) {
        this.addresId = addresId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
