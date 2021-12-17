package fr.iut.csid.bonsai.domain.model;

import java.util.Date;
import java.util.UUID;

public class Bonsai {
    private UUID id;
    private String name;
    private String species;
    private String status;
    private String acquisition_date;
    private int acquisition_age;
    private Date last_watering;
    //Envisager les localDate

    public Bonsai(UUID id, String name, String species, String status, String acquisition_date, int acquisition_age, Date last_watering) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.status = status;
        this.acquisition_date = acquisition_date;
        this.acquisition_age = acquisition_age;
        this.last_watering = last_watering;
    }

    public Bonsai() {
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(String acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public Date getLast_watering() {
        return last_watering;
    }

    public void setLast_watering(Date last_watering) {
        this.last_watering = last_watering;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
