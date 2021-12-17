package fr.iut.csid.bonsai.exposition;

import fr.iut.csid.bonsai.domain.model.Bonsai;

import java.util.Date;
import java.util.UUID;

public class BonsaiDTO {
    private UUID id;
    private String name;
    private String species;
    private int acquisition_age;
    private String acquisition_date;

    private Date last_watering;
    private String status;

    public BonsaiDTO(Bonsai bonsai){
        this.id = bonsai.getId();
        this.name = bonsai.getName();
        this.species = bonsai.getSpecies();
        this.acquisition_age = bonsai.getAcquisition_age();
        this.last_watering = bonsai.getLast_watering();
        this.status = bonsai.getStatus();
        this.acquisition_date= bonsai.getAcquisition_date();
    }
    public BonsaiDTO(){

    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
