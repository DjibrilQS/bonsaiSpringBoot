package fr.iut.csid.bonsai.infrastructure;

import fr.iut.csid.Common.RepottingDao;
import fr.iut.csid.Common.RepottingEntity;
import fr.iut.csid.bonsai.domain.model.Repotting;
import fr.iut.csid.bonsai.exposition.RepottingMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class RepottingRepository {

    private RepottingDao repottingDao;

    public RepottingRepository(RepottingDao repottingDao) {
        this.repottingDao = repottingDao;
    }

    public List<Repotting> findAll(UUID id_bonsai) {
        List<RepottingEntity> filterdRepottingEntityList = repottingDao.findAllBy(id_bonsai);

        List<Repotting> wateringList = new ArrayList<>();

        for (RepottingEntity repottingEntity : filterdRepottingEntityList)
            wateringList.add(RepottingMapper.mapFromEntity(repottingEntity));
        return wateringList;
    }

//    public Repotting save(Repotting repotting) {
//        RepottingEntity repo = repottingDao.save(RepottingMapper.mapEntityFromRepotting(repotting));
//        return RepottingMapper.mapFromEntity(repo);
//    }
}
