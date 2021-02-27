package com.example.restservice.models.prescription;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "prescription")
public class Prescription {
    @Id
    private String id;
    private String regId;
    private String doctorId;
    private String createdOn;
    private String modifiedOn;
    private String bloodPressure;
    private String pulseRate;
    private String weight;
    private List<String> allergies;
    private List<String> disabilities;
    private List<Medicine> medicines;

    public Prescription(String id,
                        String regId,
                        String doctorId,
                        String createdOn,
                        String modifiedOn,
                        String bloodPressure,
                        String pulseRate,
                        String weight,
                        List<String> allergies,
                        List<String> disabilities,
                        List<Medicine> medicines) {
        this.id = id;
        this.regId = regId;
        this.doctorId = doctorId;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.bloodPressure = bloodPressure;
        this.pulseRate = pulseRate;
        this.weight = weight;
        this.allergies = allergies;
        this.disabilities = disabilities;
        this.medicines = medicines;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
