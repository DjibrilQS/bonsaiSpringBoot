package fr.iut.csid.owner.domain.models;


import java.util.Date;
import java.util.UUID;

public class BonsaiOwner {

    private UUID id;
    private String name;
    private String species;
    private int acquisition_age;
    private String status;
    private String acquisition_date;
    private UUID id_owner;
    private Date last_watering;
    private Date last_pruning;
    private Date last_repotting;


    public BonsaiOwner(UUID id, String name, String species, String status, String acquisition_date, int acquisition_age, UUID id_owner, Date last_watering, Date last_pruning, Date last_repotting) {
        this.id=id;
        this.name = name;
        this.species = species;
        this.status = status;
        this.acquisition_date = acquisition_date;
        this.acquisition_age = acquisition_age;
        this.id_owner = id_owner;
        this.last_watering = last_watering;
        this.last_pruning= last_pruning;
        this.last_repotting = last_repotting;
    }

    public BonsaiOwner update(BonsaiOwner bonsai){
        if (bonsai.getName() != null){
            this.name = bonsai.getName();
        }
        if (bonsai.getSpecies()!= null){
            this.species = bonsai.getSpecies();
        }
        if (bonsai.getAcquisition_date()!= null){
            this.acquisition_date = bonsai.getAcquisition_date();
        }
        if (bonsai.getAcquisition_age()!= 0){
            this.acquisition_age = bonsai.getAcquisition_age();
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getStatus() {
        return status;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public UUID getId() {
        return id;
    }

    public UUID getId_owner() {
        return id_owner;
    }

    public Date getLast_pruning() {
        return last_pruning;
    }

    public Date getLast_repotting() {
        return last_repotting;
    }

    public Date getLast_watering() {
        return last_watering;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAcquisition_date(String acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public void setId_owner(UUID id_owner) {
        this.id_owner = id_owner;
    }
}