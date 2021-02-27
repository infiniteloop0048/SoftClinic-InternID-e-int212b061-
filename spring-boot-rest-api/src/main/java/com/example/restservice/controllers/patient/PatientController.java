package com.example.restservice.controllers.patient;


import com.example.restservice.models.doctor.Doctor;
import com.example.restservice.models.patient.Patient;
import com.example.restservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/patients/namedob/{name}/{dob}")
    public ResponseEntity<List<Patient>> getPatientByDobAndName(@PathVariable("name") String name, @PathVariable("dob")String dob){
        try {
            System.out.println(name);
            System.out.println(dob);
            List<Patient> patients = patientRepository.findByNameAndDob(name, dob);
            if(patients.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(patients, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatientById(@PathVariable("id") String id, @RequestBody Patient patient){
        Optional<Patient> patientData = patientRepository.findById(id);
        if (patientData.isPresent()) {
            Patient _patient = patientData.get();
            _patient.setDoctorId(patient.getDoctorId());
            _patient.setHospitalId(patient.getHospitalId());
            _patient.setUPI(patient.getUPI());
            _patient.setRegDate(patient.getRegDate());
            _patient.setName(patient.getName());
            _patient.setDoctorId(patient.getDoctorId());
            _patient.setAge(patient.getAge());
            _patient.setGender(patient.getGender());
            _patient.setOccupation(patient.getOccupation());
            _patient.setHealthInsuranceNo(patient.getHealthInsuranceNo());
            _patient.setHealthCareProvider(patient.getHealthCareProvider());
            _patient.setAddress(patient.getAddress());
            _patient.setContact(patient.getContact());
            _patient.setCreatedOn(patient.getCreatedOn());

            return new ResponseEntity<>(patientRepository.save(_patient), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") String id) {
        try {
            patientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patients")
    public ResponseEntity<HttpStatus> deleteAllPatients() {
        try {
            patientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
