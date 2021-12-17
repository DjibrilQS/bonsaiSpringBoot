package fr.iut.csid.bonsai.exposition;

import fr.iut.csid.bonsai.domain.model.Bonsai;
import fr.iut.csid.Common.BonsaiEntity;

import java.util.Date;

public class BonsaiMapper {
    public static Bonsai mapfromEntity(BonsaiEntity bonsaiEntity){
        Date lastWatering;
        if (bonsaiEntity.getListeWaterings()== null || bonsaiEntity.getListeWaterings().isEmpty())
            lastWatering = null;
        else
            lastWatering = bonsaiEntity.getListeWaterings().get(0).getDate();
//        wateringDTO.setDate(watering.getDate().toString().replaceAll("T", " "));
        return new Bonsai(bonsaiEntity.getId(),bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getStatus(), bonsaiEntity.getAcquisition_date(), bonsaiEntity.getAcquisition_age(), lastWatering/*, lastPruning, lastRepotting*/);
    }

    public static BonsaiDTO bonsaiToDTO(Bonsai bonsai) {
        BonsaiDTO bdt = new BonsaiDTO();
        bdt.setLast_watering(bonsai.getLast_watering());
        bdt.setStatus(bonsai.getStatus());
        bdt.setSpecies(bonsai.getSpecies());
        bdt.setName(bonsai.getName());
        bdt.setAcquisition_age(bonsai.getAcquisition_age());
        bdt.setAcquisition_date(bonsai.getAcquisition_date());
        bdt.setId(bdt.getId());
        return bdt;
    }

    public static BonsaiDTO mappingPatch(Bonsai bonsai){
        BonsaiDTO bdt = new BonsaiDTO();
        bdt.setSpecies(bonsai.getSpecies());
        bdt.setName(bonsai.getName());
        bdt.setAcquisition_age(bonsai.getAcquisition_age());
        bdt.setAcquisition_date(bonsai.getAcquisition_date());
        return bdt;
    }
    public static Bonsai dtoToBonsai(BonsaiDTO bdt) {

        Bonsai bonsai = new Bonsai(bdt.getId(), bdt.getName(), bdt.getSpecies(), bdt.getStatus(), bdt.getAcquisition_date().toString(), bdt.getAcquisition_age(), bdt.getLast_watering());

        return bonsai;

    }

    public static BonsaiEntity dtoToBonsaiEntity(Bonsai bdt) {
        BonsaiEntity bonsai = new BonsaiEntity();
        bonsai.setName(bdt.getName());
        bonsai.setId(bdt.getId());
        return bonsai;
    }

    public static BonsaiDTO entityToDto(BonsaiEntity be) {
        BonsaiDTO bonsai = new BonsaiDTO();
        bonsai.setName(be.getName());
        bonsai.setId(be.getId());
        bonsai.setAcquisition_age(be.getAcquisition_age());
        bonsai.setAcquisition_date(be.getAcquisition_date());
        bonsai.setSpecies(be.getSpecies());
        bonsai.setStatus(be.getStatus());
        if(be.getListeWaterings() != null ) {
            if (!be.getListeWaterings().isEmpty())
                bonsai.setLast_watering(be.getListeWaterings().get(0).getDate());
        }
        return bonsai;
    }
    public static BonsaiEntity bonsaiToEntity(Bonsai b){
        BonsaiEntity bonsai = new BonsaiEntity();
        bonsai.setId(b.getId());
        bonsai.setName(b.getName());
        bonsai.setAcquisition_age(b.getAcquisition_age());
        bonsai.setAcquisition_date(b.getAcquisition_date());
        bonsai.setSpecies(b.getSpecies());
        bonsai.setStatus(b.getStatus());
        return bonsai;
    }
}
