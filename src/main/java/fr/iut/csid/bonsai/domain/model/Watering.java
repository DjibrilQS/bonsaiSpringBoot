package fr.iut.csid.bonsai.domain.model;

import java.util.Date;
import java.util.UUID;

public class Watering {

    private UUID id_watering;
    private Date date;
    private Bonsai bonsai;

    public Watering(UUID id_watering, Date date, Bonsai bonsai) {
        this.id_watering = id_watering;
        this.date = date;
        this.bonsai = bonsai;
    }

    public UUID getId_watering() {
        return id_watering;
    }

    public void setId_watering(UUID id_watering) {
        this.id_watering = id_watering;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bonsai getBonsai() {
        return bonsai;
    }

    public void setBonsai(Bonsai bonsai) {
        this.bonsai = bonsai;
    }
}
