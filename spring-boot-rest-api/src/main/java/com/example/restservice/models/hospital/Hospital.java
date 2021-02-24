package com.example.restservice.models.hospital;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hospital")
public class Hospital {
    @Id
    private String id;
    private String name;
    private String branch;
    private Address address;
    private String email;
    private String contact;
    private String createdOn;

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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCreated_on() {
        return createdOn;
    }

    public void setCreated_on(String createdOn) {
        this.createdOn = createdOn;
    }

    public Hospital(String id,
                    String name,
                    String branch,
                    Address address,
                    String email,
                    String contact,
                    String createdOn) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.createdOn = createdOn;
    }
}
