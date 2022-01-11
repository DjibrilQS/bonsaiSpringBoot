
package fr.iut.csid.bonsai.domain.model;

import java.util.Date;
import java.util.UUID;

public class Pruning {
    private UUID id_pruning;
    private Date date;
    private Bonsai bonsai;

    public Pruning(UUID id_pruning, Date date, Bonsai bonsai) {
        this.id_pruning = id_pruning;
        this.date = date;
        this.bonsai = bonsai;
    }

    public UUID getId_pruning() {
        return id_pruning;
    }

    public void setId_pruning(UUID id_pruning) {
        this.id_pruning = id_pruning;
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
