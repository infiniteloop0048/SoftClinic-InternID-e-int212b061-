package com.example.restservice.controllers.patient;


import com.example.restservice.models.hospital.Hospital;
import com.example.restservice.models.patient.Patient;
import com.example.restservice.repository.PatientRepository;
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
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        try {
            Patient _patient = patientRepository.save(new Patient(
                    patient.getId(),
                    patient.getDoctorId(),
                    patient.getHospitalId(),
                    patient.getUPI(),
                    patient.getName(),
                    patient.getRegDate(),
                    patient.getDob(),
                    patient.getAge(),
                    patient.getGender(),
                    patient.getOccupation(),
                    patient.getHealthInsuranceNo(),
                    patient.getHealthCareProvider(),
                    patient.getAddress(),
                    patient.getContact(),
                    patient.getCreatedOn()
                    ));
            return new ResponseEntity<>(_patient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        try {
            List<Patient> patients = new ArrayList<Patient>();
            patientRepository.findAll().forEach(patients::add);
            if (patients.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients/id/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") String id){
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            return new ResponseEntity<>(patient.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/patients/name/{name}")
    public ResponseEntity<List<Patient>> getPatientByName(@PathVariable("name") String name){
        List<Patient> patients = new ArrayList<>();
        patients = patientRepository.findByName(name);
        if(!patients.isEmpty()){
            return new ResponseEntity<>(patients, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
