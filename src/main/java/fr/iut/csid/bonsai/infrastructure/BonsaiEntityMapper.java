package fr.iut.csid.bonsai.infrastructure;

import fr.iut.csid.Common.BonsaiEntity;
import fr.iut.csid.bonsai.domain.model.Bonsai;

public class BonsaiEntityMapper {
    public static BonsaiEntity bonsaiToEntity(Bonsai bons){
        BonsaiEntity be = new BonsaiEntity();
        be.setId(bons.getId());
        be.setName(bons.getName());
        be.setStatus(bons.getStatus());
        be.setSpecies(bons.getSpecies());
        be.setAcquisition_date(bons.getAcquisition_date());
        be.setAcquisition_age(bons.getAcquisition_age());
        return be;
    }
}
