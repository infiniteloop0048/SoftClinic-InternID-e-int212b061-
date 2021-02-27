package com.example.restservice.repository;

import com.example.restservice.models.prescription.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
    List<Prescription> findByRegId(String regId);
}
