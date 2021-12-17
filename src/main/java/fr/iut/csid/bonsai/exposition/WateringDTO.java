package fr.iut.csid.bonsai.exposition;

import java.util.UUID;

public class WateringDTO {

    private UUID id_watering;
    private String date;

    public WateringDTO() {
    }

    public UUID getId_watering() {
        return id_watering;
    }

    public void setId_watering(UUID id_watering) {
        this.id_watering = id_watering;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
