package fr.iut.csid.bonsai.exposition;

import java.util.UUID;

public class PruningDTO {

    private UUID id_pruning;
    private String date;

    public PruningDTO() {
    }

    public UUID getId_pruning() {
        return id_pruning;
    }

    public void setId_pruning(UUID id_pruning) {
        this.id_pruning = id_pruning;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
