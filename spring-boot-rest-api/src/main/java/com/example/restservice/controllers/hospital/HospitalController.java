package com.example.restservice.controllers.hospital;

import com.example.restservice.models.hospital.Hospital;
import com.example.restservice.models.tutorial.Tutorial;
import com.example.restservice.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;

    @PostMapping("/hospitals")
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) {
        try {
            Hospital _hospital = hospitalRepository.save(new Hospital(
                    hospital.getId(),
                    hospital.getName(),
                    hospital.getBranch(),
                    hospital.getAddress(),
                    hospital.getEmail(),
                    hospital.getContact(),
                    hospital.getCreated_on()));
            return new ResponseEntity<>(_hospital, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        try {
            List<Hospital> hospitals = new ArrayList<Hospital>();
            hospitalRepository.findAll().forEach(hospitals::add);
            if (hospitals.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(hospitals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hospitals/id/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") String id){
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if(hospital.isPresent()){
            return new ResponseEntity<>(hospital.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hospitals/name/{name}")
    public ResponseEntity<Hospital> getHospitalByName(@PathVariable("name") String name){
        Optional<Hospital> hospital = hospitalRepository.findByName(name);
        if(hospital.isPresent()){
            return new ResponseEntity<>(hospital.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }



}
