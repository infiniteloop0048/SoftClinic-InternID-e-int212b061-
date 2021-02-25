package com.example.restservice.repository;

import com.example.restservice.models.doctor.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.print.Doc;
import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Optional<Doctor> findByName(String name);
}
