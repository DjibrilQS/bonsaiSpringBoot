package fr.iut.csid.owner.domain.models;

//import fr.iut.csid.bonsai.exposition.Status;
import fr.iut.csid.Common.BonsaiEntity;
import fr.iut.csid.Common.OwnerEntity;
import fr.iut.csid.owner.exposition.BonsaiOwnerDTO;
import fr.iut.csid.owner.exposition.OwnerDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Mapper {

    public static Owner mapOwnerFromEntity(OwnerEntity ownerEntity){
        List<BonsaiOwner> bonsais = ownerEntity.getBonsais().stream().map(Mapper::mapfromEntity).collect(Collectors.toList());
        return new Owner(ownerEntity.getId_owner(), ownerEntity.getName(), bonsais);
    }

    public static Owner mapOwnerFromDTO(OwnerDTO owner) {
        return new Owner(owner.getId(), owner.getName(), null);
    }

    public static BonsaiOwner mapfromEntity(BonsaiEntity bonsaiEntity){
        Date lastWatering;
        if (bonsaiEntity.getListeWaterings()== null || bonsaiEntity.getListeWaterings().isEmpty()) {
            lastWatering = null;
        }
        else
            lastWatering = bonsaiEntity.getListeWaterings().get(0).getDate();
//        Date lastPruning;
//        if (bonsaiEntity.getListePrunings() == null || bonsaiEntity.getListePrunings().isEmpty())
//            lastPruning = null;
//        else
//            lastPruning = bonsaiEntity.getListePrunings().get(0).getDate();
//        Date lastRepotting;
//        if (bonsaiEntity.getListeRepottings() == null || bonsaiEntity.getListeRepottings().isEmpty())
//            lastRepotting = null;
//        else
//            lastRepotting = bonsaiEntity.getListeRepottings().get(0).getDate();
//
        UUID idOwner;
        if(bonsaiEntity.getOwner() == null){
            idOwner = null;
        }
        else
            idOwner = bonsaiEntity.getOwner().getId_owner();
        return new BonsaiOwner(bonsaiEntity.getId(),bonsaiEntity.getName(), bonsaiEntity.getSpecies(),bonsaiEntity.getStatus(), bonsaiEntity.getAcquisition_date(), bonsaiEntity.getAcquisition_age(), idOwner, lastWatering);
    }


    public static BonsaiOwner mapfromDTO(BonsaiOwnerDTO bonsaiDTO){
        return new BonsaiOwner(bonsaiDTO.getId(), bonsaiDTO.getName(), bonsaiDTO.getSpecies(), "unknown", null, bonsaiDTO.getAcquisition_age(), null, null/*, null, null*/);
    }
}
