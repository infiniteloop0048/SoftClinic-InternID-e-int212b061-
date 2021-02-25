package com.example.restservice.models.patient;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
public class Patient {
    @Id
    private String id;
    private String doctorId;
    private String hospitalId;
    private String UPI;
    private String name;
    private String regDate;
    private String dob;
    private String age;
    private String gender;
    private String occupation;
    private String healthInsuranceNo;
    private String healthCareProvider;
    private Address address;
    private String contact;
    private String createdOn;

    public Patient(String id,
                   String doctorId,
                   String hospitalId,
                   String UPI,
                   String name,
                   String regDate,
                   String dob,
                   String age,
                   String gender,
                   String occupation,
                   String healthInsuranceNo,
                   String healthCareProvider,
                   Address address,
                   String contact,
                   String createdOn) {
        this.id = id;
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
        this.UPI = UPI;
        this.name = name;
        this.regDate = regDate;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.healthInsuranceNo = healthInsuranceNo;
        this.healthCareProvider = healthCareProvider;
        this.address = address;
        this.contact = contact;
        this.createdOn = createdOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getUPI() {
        return UPI;
    }

    public void setUPI(String UPI) {
        this.UPI = UPI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public String getHealthInsuranceNo() {
        return healthInsuranceNo;
    }

    public void setHealthInsuranceNo(String healthInsuranceNo) {
        this.healthInsuranceNo = healthInsuranceNo;
    }

    public String getHealthCareProvider() {
        return healthCareProvider;
    }

    public void setHealthCareProvider(String healthCareProvider) {
        this.healthCareProvider = healthCareProvider;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
