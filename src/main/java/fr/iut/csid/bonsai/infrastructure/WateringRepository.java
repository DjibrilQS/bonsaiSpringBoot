package fr.iut.csid.bonsai.infrastructure;

import fr.iut.csid.Common.WateringDao;
import fr.iut.csid.Common.WateringEntity;
import fr.iut.csid.bonsai.domain.model.Watering;
import fr.iut.csid.bonsai.exposition.WateringMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class WateringRepository {

    private WateringDao wateringDao;

    public WateringRepository(WateringDao wateringDao) {
        this.wateringDao = wateringDao;
    }

    public List<Watering> findAll(UUID id_bonsai) {
        List<WateringEntity> filterdWateringEntityList = wateringDao.findAllByBonsaiId(id_bonsai);

        List<Watering> wateringList = new ArrayList<>();

        for (WateringEntity wateringEntity : filterdWateringEntityList)
            wateringList.add(WateringMapper.mapFromEntity(wateringEntity));

        return wateringList;
    }

    public Watering save(Watering watering) {
        WateringEntity wateringRes = wateringDao.save(WateringMapper.mapEntityFromWatering(watering));
        return WateringMapper.mapFromEntity(wateringRes);
    }
}
