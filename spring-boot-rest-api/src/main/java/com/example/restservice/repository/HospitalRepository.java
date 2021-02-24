package com.example.restservice.repository;



import com.example.restservice.models.hospital.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface HospitalRepository extends MongoRepository<Hospital, String> {
    Optional<Hospital> findByName(String name);
}