package fr.iut.csid.bonsai.infrastructure;


import fr.iut.csid.Common.PruningDao;
import fr.iut.csid.Common.PruningEntity;
import fr.iut.csid.bonsai.domain.model.Pruning;
import fr.iut.csid.bonsai.exposition.PruningMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PruningRepository {
    private PruningDao pruningDao;

    public PruningRepository(PruningDao pruningDao) {
        this.pruningDao = pruningDao;
    }

    public List<Pruning> findAll(UUID id_bonsai) {
        List<PruningEntity> filterdPruningEntityList = pruningDao.findAllByBonsaiId(id_bonsai);

        List<Pruning> wateringList = new ArrayList<>();

        for (PruningEntity pruningEntity : filterdPruningEntityList)
            wateringList.add(PruningMapper.entityToPruning(pruningEntity));

        return wateringList;
    }

    public Pruning save(Pruning pruning){
        PruningEntity pruningEntity = pruningDao.save(PruningMapper.pruningToEntity(pruning));
        return PruningMapper.entityToPruning(pruningEntity);
    }
}
