package com.example.restservice.models.patient;

public class Address {
    private String street;
    private String postOffice;
    private String upazila;
    private String district;
    private String division;

    public Address(String street, String postOffice, String upazila, String district, String division) {
        this.street = street;
        this.postOffice = postOffice;
        this.upazila = upazila;
        this.district = district;
        this.division = division;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getUpazila() {
        return upazila;
    }

    public void setUpazila(String upazila) {
        this.upazila = upazila;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}