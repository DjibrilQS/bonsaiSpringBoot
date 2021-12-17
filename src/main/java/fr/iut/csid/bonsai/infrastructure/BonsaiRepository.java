package fr.iut.csid.bonsai.infrastructure;

import fr.iut.csid.bonsai.domain.model.Bonsai;
import fr.iut.csid.bonsai.domain.model.Watering;
import fr.iut.csid.bonsai.exposition.BonsaiDTO;
import fr.iut.csid.bonsai.exposition.WateringMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static fr.iut.csid.bonsai.exposition.BonsaiMapper.entityToDto;
import static fr.iut.csid.bonsai.infrastructure.BonsaiEntityMapper.bonsaiToEntity;


@Component
public class BonsaiRepository {

    private BonsaiDao bonsaiDao;
    private WateringDao wateringDao;
    public BonsaiRepository(BonsaiDao bdao, WateringDao wdao){
     this.bonsaiDao = bdao;
     this.wateringDao = wdao;
    }

    public Bonsai getBonsaiByID(UUID id){
        BonsaiEntity bonsai;
        Optional<BonsaiEntity> obe = this.bonsaiDao.findById(id);
        if(obe.isPresent()) {
            bonsai = this.bonsaiDao.findById(id).get();
            if(!bonsai.getListeWaterings().isEmpty())
                return new Bonsai(id, bonsai.getName(), bonsai.getSpecies(), bonsai.getStatus(), bonsai.getAcquisition_date(), bonsai.getAcquisition_age(), bonsai.getListeWaterings().get(0).getDate());
            return new Bonsai(id, bonsai.getName(), bonsai.getSpecies(), bonsai.getStatus(), bonsai.getAcquisition_date(), bonsai.getAcquisition_age(), null);
        }
        return null;
    }

    public BonsaiEntity createBonsai(Bonsai bons) {
        Bonsai newBons = new Bonsai();
        newBons.setName(bons.getName());
        newBons.setSpecies(bons.getSpecies());
        newBons.setAcquisition_date(bons.getAcquisition_date());
        newBons.setAcquisition_age(bons.getAcquisition_age());
        newBons.setStatus("unknown");
        BonsaiEntity be = bonsaiToEntity(newBons);
        return this.bonsaiDao.save(be);
    }

    public List<BonsaiDTO> getAllBonsai() {
        List<BonsaiEntity> bonsaiList =  this.bonsaiDao.findAll();
        List<BonsaiDTO> list = new ArrayList<>();
        for (BonsaiEntity bonsai:bonsaiList) {
            BonsaiDTO bons = entityToDto(bonsai);
            list.add(bons);
        }
        return list;
    }

    public void deleteBonsai(UUID uuid) {
        this.bonsaiDao.deleteById(uuid);
    }

    public List<Watering> findAllWaterings(UUID id_bonsai) {
        List<WateringEntity> filterdWateringEntityList = wateringDao.findAllByBonsaiId(id_bonsai);

        List<Watering> wateringList = new ArrayList<>();

        for (WateringEntity wateringEntity : filterdWateringEntityList)
            wateringList.add(WateringMapper.mapFromEntity(wateringEntity));
        return wateringList;
    }

    public Watering save(Watering watering){
        WateringEntity wateringRes = wateringDao.save(WateringMapper.mapEntityFromWatering(watering));
        return WateringMapper.mapFromEntity(wateringRes);
    }
}
