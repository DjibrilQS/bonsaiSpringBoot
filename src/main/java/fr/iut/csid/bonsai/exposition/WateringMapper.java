package fr.iut.csid.bonsai.exposition;

import fr.iut.csid.bonsai.domain.model.Bonsai;
import fr.iut.csid.bonsai.domain.model.Watering;
import fr.iut.csid.Common.WateringEntity;


import java.util.Date;

public class WateringMapper {

    public static Watering mapFromEntity(WateringEntity wateringEntity){
        return new Watering(wateringEntity.getId_watering(), wateringEntity.getDate(), BonsaiMapper.mapfromEntity(wateringEntity.getBonsai()));
    }

    public static Watering mapFromDTO(WateringDTO wateringDTO, Bonsai bonsai){
        return new Watering(wateringDTO.getId_watering(), new Date(wateringDTO.getDate()), bonsai);
    }
    public static WateringDTO mapFromWatering(Watering watering){
        WateringDTO wateringDTO = new WateringDTO();
        wateringDTO.setId_watering(watering.getId_watering());
        wateringDTO.setDate(watering.getDate().toString().replaceAll("T", " "));
        return wateringDTO;
    }
    public static WateringEntity mapEntityFromWatering(Watering watering){
        WateringEntity wateringEntity = new WateringEntity();
        wateringEntity.setId_watering(watering.getId_watering());
        wateringEntity.setDate(watering.getDate());
        wateringEntity.setBonsai(BonsaiMapper.bonsaiToEntity(watering.getBonsai()));
        return wateringEntity;
    }
}
