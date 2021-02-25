package com.example.restservice.controllers.test;


import com.example.restservice.models.hospital.Hospital;
import com.example.restservice.models.test.Test;
import com.example.restservice.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TestController {
    @Autowired
    TestRepository testRepository;

    @PostMapping("/tests")
    public ResponseEntity<Test> createHospital(@RequestBody Test test) {
        try {
            Test _test = testRepository.save(new Test(
                    test.getId(),
                    test.getName()
                    ));
            return new ResponseEntity<>(_test, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tests")
    public ResponseEntity<List<Test>> getAllHospitals() {
        try {
            List<Test> tests = new ArrayList<Test>();
            testRepository.findAll().forEach(tests::add);
            if (tests.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
