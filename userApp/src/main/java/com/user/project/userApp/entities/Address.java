package com.user.project.userApp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "address_line")
    @NotBlank(message = "Address Line!")
    private String addressLine;
    @Column(name = "address_no")
    @NotNull(message = "Number is required!")
    private Integer addressNo;
    @Column(name = "zip_code")
    @NotNull(message = "Zipcode is required!")
    private Integer zipCode;
    @Column(name = "city")
    @NotBlank(message = "City is required!")
    private String city;
    @Column(name = "lng")
    private double lng;
    @Column(name = "lat")
    private double lat;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public Integer getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(Integer addressNo) {
        this.addressNo = addressNo;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
