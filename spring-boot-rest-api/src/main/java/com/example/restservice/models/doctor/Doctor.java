package com.example.restservice.models.doctor;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctor")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String hospitalId;
    private String speciality;
    private Address address;
    private String about;
    private String profilePicture;
    private String createdOn;

    public Doctor(String id,
                  String name,
                  String hospitalId,
                  String speciality,
                  Address address,
                  String about,
                  String profilePicture,
                  String createdOn) {
        this.id = id;
        this.name = name;
        this.hospitalId = hospitalId;
        this.speciality = speciality;
        this.address = address;
        this.about = about;
        this.profilePicture = profilePicture;
        this.createdOn = createdOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
