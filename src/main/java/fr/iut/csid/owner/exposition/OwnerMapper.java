package fr.iut.csid.owner.exposition;


import fr.iut.csid.Common.BonsaiEntity;
import fr.iut.csid.Common.OwnerEntity;
import fr.iut.csid.owner.domain.models.BonsaiOwner;
import fr.iut.csid.owner.domain.models.Owner;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OwnerMapper {

    public static OwnerDTO mapDTOFromOwner(Owner owner){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getUuid());
        ownerDTO.setName(owner.getName());
        ownerDTO.setBonsais(owner.getBonsais().stream().map(OwnerMapper::mapDTOFromBonsaiOwner).collect(Collectors.toList()));
        return ownerDTO;
    }

    public static BonsaiOwnerDTO mapDTOFromBonsaiOwner(BonsaiOwner bonsaiOwner){
        return new BonsaiOwnerDTO(bonsaiOwner.getId(), bonsaiOwner.getName(), bonsaiOwner.getSpecies(), bonsaiOwner.getAcquisition_age());
    }
    public static OwnerEntity mapFromOwner(Owner owner){
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId_owner(owner.getUuid());
        ownerEntity.setName(owner.getName());
        ownerEntity.setBonsais(new ArrayList<BonsaiEntity>());
        return ownerEntity;
    }

    public static Owner mapFromEntity(OwnerEntity ownerEntity){
        Owner owner = new Owner();
        owner.setUuid(ownerEntity.getId_owner());
        owner.setName(ownerEntity.getName());
        owner.setBonsais(new ArrayList<BonsaiOwner>());
        return owner;
    }
}
