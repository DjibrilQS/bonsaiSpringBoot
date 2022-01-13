package fr.iut.csid.owner.exposition;

import java.util.List;
import java.util.UUID;

public class OwnerDTO {

    private UUID id;
    private String name;
    private List<BonsaiOwnerDTO> bonsais;

    public OwnerDTO() {
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

    public List<BonsaiOwnerDTO> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<BonsaiOwnerDTO> bonsais) {
        this.bonsais = bonsais;
    }
}
