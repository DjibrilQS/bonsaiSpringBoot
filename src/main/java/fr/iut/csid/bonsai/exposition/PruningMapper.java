package fr.iut.csid.bonsai.exposition;


import fr.iut.csid.Common.PruningEntity;
import fr.iut.csid.bonsai.domain.model.Pruning;

public class PruningMapper {

    public static Pruning entityToPruning(PruningEntity pruningEntity) {
        return new Pruning(pruningEntity.getId_pruning(), pruningEntity.getDate(), BonsaiMapper.mapfromEntity(pruningEntity.getBonsai()));
    }

    public static PruningEntity pruningToEntity(Pruning pruning) {
        PruningEntity pruningEntity = new PruningEntity();
        pruningEntity.setId_pruning(pruning.getId_pruning());
        pruningEntity.setDate(pruning.getDate());
        pruningEntity.setBonsai(BonsaiMapper.bonsaiToEntity(pruning.getBonsai()));
        return pruningEntity;
    }

    public static PruningDTO pruningToDTO(Pruning pruning) {
        PruningDTO pruningDTO = new PruningDTO();
        pruningDTO.setId_pruning(pruning.getId_pruning());
        pruningDTO.setDate(pruning.getDate().toString().replaceAll("T", " "));
        return pruningDTO;
    }
}
