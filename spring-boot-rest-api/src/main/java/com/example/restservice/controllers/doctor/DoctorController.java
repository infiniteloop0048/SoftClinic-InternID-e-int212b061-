package com.example.restservice.controllers.doctor;


import com.example.restservice.models.doctor.Doctor;
import com.example.restservice.models.hospital.Hospital;
import com.example.restservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        try {
            Doctor _doctor = doctorRepository.save(new Doctor(
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getHospitalId(),
                    doctor.getSpeciality(),
                    doctor.getAddress(),
                    doctor.getAbout(),
                    doctor.getProfilePicture(),
                    doctor.getCreatedOn()));
            return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        try {
            List<Doctor> doctors = new ArrayList<Doctor>();
            doctors = doctorRepository.findAll();
            if (doctors.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctors/id/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") String id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(doctor.isPresent()){
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/doctors/name/{name}")
    public ResponseEntity<Doctor> getDoctorByName(@PathVariable("name") String name){
        Optional<Doctor> doctor = doctorRepository.findByName(name);
        if(doctor.isPresent()){
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctorById(@PathVariable("id") String id, @RequestBody Doctor doctor){
        Optional<Doctor> doctorData = doctorRepository.findById(id);
        if (doctorData.isPresent()) {
            Doctor _doctor = doctorData.get();
            _doctor.setName(doctor.getName());
            _doctor.setAddress(doctor.getAddress());
            _doctor.setHospitalId(doctor.getHospitalId());
            _doctor.setSpeciality(doctor.getSpeciality());
            _doctor.setProfilePicture(doctor.getProfilePicture());
            _doctor.setAbout(doctor.getAbout());
            _doctor.setCreatedOn(doctor.getCreatedOn());
            return new ResponseEntity<>(doctorRepository.save(_doctor), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("id") String id) {
        try {
            doctorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/doctors")
    public ResponseEntity<HttpStatus> deleteAllDoctors() {
        try {
            doctorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
