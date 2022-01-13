package fr.iut.csid.Common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "pruning")
@Table(name = "pruning")
public class PruningEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id_pruning;

    @Column(name = "datetime")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_bonsai")
    private BonsaiEntity bonsai;

    public PruningEntity() {
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

    public BonsaiEntity getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }
}
