package fr.iut.csid.Common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "bonsai")
@Table(name = "bonsai")
public class BonsaiEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_bonsai")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name="species")
    private String species;

    @Column(name="acquisition_date")
    private String acquisition_date;

    @Column(name="acquisition_age")
    private int acquisition_age;

    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_owner")
    private OwnerEntity owner;

    @OneToMany(targetEntity = WateringEntity.class, mappedBy="bonsai", cascade = CascadeType.REMOVE)
    private List<WateringEntity> listeWaterings;

    @OneToMany(targetEntity = PruningEntity.class, mappedBy="bonsai", cascade = CascadeType.REMOVE)
    private List<PruningEntity> listePrunings;

    @OneToMany(targetEntity = RepottingEntity.class, mappedBy="bonsai", cascade = CascadeType.REMOVE)
    private List<RepottingEntity> listeRepottings;

    public BonsaiEntity() {

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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(String acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public List<WateringEntity> getListeWaterings() {
        return listeWaterings;
    }

    public void setListeWaterings(List<WateringEntity> listeWaterings) {
        this.listeWaterings = listeWaterings;
    }

    public List<PruningEntity> getListePrunings() {
        return listePrunings;
    }

    public void setListePrunings(List<PruningEntity> listePrunings) {
        this.listePrunings = listePrunings;
    }

    public List<RepottingEntity> getListeRepottings() {
        return listeRepottings;
    }

    public void setListeRepottings(List<RepottingEntity> listeRepottings) {
        this.listeRepottings = listeRepottings;
    }
}