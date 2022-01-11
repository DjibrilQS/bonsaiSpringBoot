package fr.iut.csid.bonsai.exposition;

import fr.iut.csid.bonsai.domain.Service.RepottingDTO;
import fr.iut.csid.bonsai.domain.model.Repotting;
import fr.iut.csid.Common.RepottingEntity;

public class RepottingMapper {

    public static RepottingDTO repottingToDTO(Repotting repotting){
        RepottingDTO repottingDTO = new RepottingDTO();
        repottingDTO.setId_repotting(repotting.getId_repotting());
        repottingDTO.setDate(repotting.getDate().toString().replaceAll("T", " "));
        return repottingDTO;
    }
    public static Repotting mapFromEntity(RepottingEntity repottingEntity){
        return new Repotting(repottingEntity.getId_repotting(), repottingEntity.getDate(), BonsaiMapper.mapfromEntity(repottingEntity.getBonsai()));
    }
    public static RepottingEntity repottingToEntity (Repotting repotting){
        RepottingEntity repottingEntity = new RepottingEntity();
        repottingEntity.setId_repotting(repotting.getId_repotting());
        repottingEntity.setDate(repotting.getDate());
        repottingEntity.setBonsai(BonsaiMapper.bonsaiToEntity(repotting.getBonsai()));
        return repottingEntity;
    }

}