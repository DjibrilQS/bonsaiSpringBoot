package fr.iut.csid.Common;

import fr.iut.csid.Common.BonsaiEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Entity(name = "owner")
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id_owner;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = BonsaiEntity.class, mappedBy = "owner", cascade = CascadeType.DETACH)
    private List<BonsaiEntity> bonsais;

    public OwnerEntity() {
    }

    public UUID getId_owner() {
        return id_owner;
    }

    public void setId_owner(UUID id_owner) {
        this.id_owner = id_owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BonsaiEntity> getBonsais() {
        return bonsais;
    }

    public void setBonsais(List<BonsaiEntity> bonsais) {
        this.bonsais = bonsais;
    }
}