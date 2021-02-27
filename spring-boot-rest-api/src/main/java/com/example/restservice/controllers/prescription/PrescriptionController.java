package com.example.restservice.controllers.prescription;


import com.example.restservice.models.patient.Patient;
import com.example.restservice.models.prescription.Prescription;
import com.example.restservice.repository.PatientRepository;
import com.example.restservice.repository.PrescriptionRepository;
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
public class PrescriptionController {
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/prescriptions")
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        try {

            Prescription _prescription = prescriptionRepository.save(new Prescription(
                    prescription.getId(),
                    prescription.getRegId(),
                    prescription.getDoctorId(),
                    prescription.getCreatedOn(),
                    prescription.getModifiedOn(),
                    prescription.getBloodPressure(),
                    prescription.getPulseRate(),
                    prescription.getWeight(),
                    prescription.getAllergies(),
                    prescription.getDisabilities(),
                    prescription.getMedicines()
            ));
            return new ResponseEntity<>(_prescription, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prescriptions")
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        try {
            List<Prescription> prescriptions = new ArrayList<Prescription>();
            prescriptionRepository.findAll().forEach(prescriptions::add);
            if (prescriptions.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(prescriptions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prescriptions/id/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable("id") String id){
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        if(prescription.isPresent()){
            return new ResponseEntity<>(prescription.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/prescriptions/patient/{id}")
    public ResponseEntity<List<Prescription>> getPrescriptionByPatientId(@PathVariable("id") String regId){
        List<Prescription> prescriptions = prescriptionRepository.findByRegId(regId);
        if(!prescriptions.isEmpty()){
            return new ResponseEntity<>(prescriptions, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/prescriptions/{name}/{dob}")
    public ResponseEntity<List<Prescription>> getPrescriptionByDobAndName(@PathVariable("name") String name, @PathVariable("dob")String dob){
        try {
            System.out.println("?????????????????????????????????");
            Optional<Patient> patient = patientRepository.findByNameAndDob(name, dob);
            System.out.println("ase?-----------------------");
            if(patient.isPresent()){
                List<Prescription> prescriptions = prescriptionRepository.findByRegId(patient.get().getId());
                if(!prescriptions.isEmpty()){
                    return new ResponseEntity<>(prescriptions, HttpStatus.OK);
                }
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> updatePrescriptionById(@PathVariable("id") String id, @RequestBody Prescription prescription){
        Optional<Prescription> prescriptionData = prescriptionRepository.findById(id);
        if (prescriptionData.isPresent()) {
            Prescription _prescription = prescriptionData.get();
            _prescription.setRegId(prescription.getRegId());
            _prescription.setDoctorId(prescription.getDoctorId());
            _prescription.setCreatedOn(prescription.getCreatedOn());
            _prescription.setModifiedOn(prescription.getModifiedOn());
            _prescription.setBloodPressure(prescription.getBloodPressure());
            _prescription.setPulseRate(prescription.getPulseRate());
            _prescription.setWeight(prescription.getWeight());
            _prescription.setAllergies(prescription.getAllergies());
            _prescription.setDisabilities(prescription.getDisabilities());
            _prescription.setMedicines(prescription.getMedicines());

            return new ResponseEntity<>(prescriptionRepository.save(_prescription), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/prescriptions/{id}")
    public ResponseEntity<HttpStatus> deletePrescription(@PathVariable("id") String id) {
        try {
            prescriptionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/prescriptions")
    public ResponseEntity<HttpStatus> deleteAllPrescriptions() {
        try {
            prescriptionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
