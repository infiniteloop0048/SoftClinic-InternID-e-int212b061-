package com.example.restservice.models.patient;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patient")
public class Patient {
    @Id
    private String regId;
    private String doctorId;
    private String hospitalId;
    private String UPI;
}
