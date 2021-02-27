package com.example.restservice.models.prescription;

public class Medicine {
    private String name;
    private String description;
    private String preCautions;

    public Medicine(String name, String description, String preCautions) {
        this.name = name;
        this.description = description;
        this.preCautions = preCautions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreCautions() {
        return preCautions;
    }

    public void setPreCautions(String preCautions) {
        this.preCautions = preCautions;
    }
}
