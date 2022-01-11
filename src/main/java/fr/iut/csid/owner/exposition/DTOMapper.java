package fr.iut.csid.owner.exposition;


import fr.iut.csid.owner.domain.models.BonsaiOwner;
import fr.iut.csid.owner.domain.models.Owner;

import java.util.stream.Collectors;

public class DTOMapper {

    public static OwnerDTO mapDTOFromOwner(Owner owner){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getUuid());
        ownerDTO.setName(owner.getName());
        ownerDTO.setBonsais(owner.getBonsais().stream().map(DTOMapper::mapLightDTOFromBonsaiOwner).collect(Collectors.toList()));
        return ownerDTO;
    }

    public static BonsaiOwnerDTO mapLightDTOFromBonsaiOwner(BonsaiOwner bonsaiOwner){
        return new BonsaiOwnerDTO(bonsaiOwner.getId(), bonsaiOwner.getName(), bonsaiOwner.getSpecies(), bonsaiOwner.getAcquisition_age());
    }
}
