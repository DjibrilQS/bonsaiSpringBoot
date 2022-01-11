package fr.iut.csid.owner.infrastructure;


import fr.iut.csid.Common.BonsaiEntity;
import fr.iut.csid.Common.OwnerEntity;
import fr.iut.csid.owner.domain.models.BonsaiOwner;
import fr.iut.csid.owner.domain.models.Owner;

import java.util.ArrayList;

public class EntityMapper {


    public static BonsaiEntity mapFromBonsaiOwner(BonsaiOwner bonsaiOwner){
        BonsaiEntity entity = new BonsaiEntity();
        entity.setId(bonsaiOwner.getId());
        entity.setAcquisition_age(bonsaiOwner.getAcquisition_age());
        entity.setAcquisition_date(bonsaiOwner.getAcquisition_date());
        entity.setName(bonsaiOwner.getName());
        entity.setSpecies(bonsaiOwner.getSpecies());
        entity.setStatus(bonsaiOwner.getStatus());
        return entity;
    }

    public static OwnerEntity mapFromOwner(Owner owner){
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId_owner(owner.getUuid());
        ownerEntity.setName(owner.getName());
        ownerEntity.setBonsais(new ArrayList<BonsaiEntity>());
        return ownerEntity;
    }
}
