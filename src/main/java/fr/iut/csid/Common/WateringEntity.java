package fr.iut.csid.Common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "watering")
@Table(name = "watering")
public class WateringEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id_watering;

    @Column(name = "date_watering")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_bonsai")
    private BonsaiEntity bonsai;

    public WateringEntity() {
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

    public BonsaiEntity getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }
}
