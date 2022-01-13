package fr.iut.csid.bonsai.domain.Service;

import java.util.UUID;

public class RepottingDTO {
    private UUID id_repotting;
    private String date;

    public RepottingDTO() {
    }

    public UUID getId_repotting() {
        return id_repotting;
    }

    public void setId_repotting(UUID id_repotting) {
        this.id_repotting = id_repotting;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
