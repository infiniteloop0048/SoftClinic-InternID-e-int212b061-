package com.example.restservice.repository;

import com.example.restservice.models.patient.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findByName(String name);
    Optional<Patient> findByNameAndDob(String name, String dob);
}
