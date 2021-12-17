package fr.iut.csid.Common;

import fr.iut.csid.Common.BonsaiEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "owner")
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id_watering;

    @Column(name = "name")
    private String name;


    @OneToMany(targetEntity = BonsaiEntity.class, mappedBy ="owner", cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_bonsai")
    private List<BonsaiEntity> bonsai;

    public OwnerEntity() {
    }

    public UUID getId_watering() {
        return id_watering;
    }

    public void setId_watering(UUID id_watering) {
        this.id_watering = id_watering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BonsaiEntity> getBonsai() {
        return bonsai;
    }

    public void setBonsai(List<BonsaiEntity> bonsai) {
        this.bonsai = bonsai;
    }
}
