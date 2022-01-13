package fr.iut.csid.owner.domain.models;


import java.util.List;
import java.util.UUID;

public class Owner {

    private UUID uuid;
    private String name;
    private List<BonsaiOwner> bonsais;

    public Owner(UUID uuid, String name, List<BonsaiOwner> bonsais) {
        this.uuid = uuid;
        this.name = name;
        this.bonsais = bonsais;
    }

    public Owner() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BonsaiOwner> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<BonsaiOwner> bonsais) {
        this.bonsais = bonsais;
    }
}
