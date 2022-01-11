package fr.iut.csid.bonsai.infrastructure;



import fr.iut.csid.Common.RepottingDao;
import fr.iut.csid.Common.RepottingEntity;
import fr.iut.csid.bonsai.domain.model.Repotting;
import fr.iut.csid.bonsai.exposition.RepottingMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RepottingRepository {
    private RepottingDao repottingDao;

    public RepottingRepository(RepottingDao repottingDao) {
        this.repottingDao = repottingDao;
    }

    public List<Repotting> findAll(UUID id_bonsai) {
        List<RepottingEntity> filterdRepottingEntityList = repottingDao.findAllBy(id_bonsai);

        List<Repotting> repottingList = new ArrayList<>();

        for (RepottingEntity repottingEntity : filterdRepottingEntityList)
            repottingList.add(RepottingMapper.mapFromEntity(repottingEntity));

        return repottingList;
    }

    public Repotting save(Repotting repotting){
        RepottingEntity repottingEntity = repottingDao.save(RepottingMapper.repottingToEntity(repotting));
        return RepottingMapper.mapFromEntity(repottingEntity);
    }
}
