package com.example.restservice.repository;

import com.example.restservice.models.test.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, String> {

}
