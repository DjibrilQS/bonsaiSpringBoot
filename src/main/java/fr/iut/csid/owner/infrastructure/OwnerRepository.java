package fr.iut.csid.owner.infrastructure;

import fr.iut.csid.Common.OwnerDao;
import fr.iut.csid.Common.OwnerEntity;

import fr.iut.csid.Common.BonsaiDao;
import fr.iut.csid.owner.domain.models.BonsaiOwner;
import fr.iut.csid.owner.domain.models.Mapper;
import fr.iut.csid.owner.domain.models.Owner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OwnerRepository {

    private OwnerDao ownerDao;
    private BonsaiDao bonsaiDao;

    public OwnerRepository(OwnerDao ownerDao, BonsaiDao bonsaisDao) {
        this.ownerDao = ownerDao;
        this.bonsaiDao = bonsaisDao;
    }

    public List<Owner> findAll(){
        List<OwnerEntity> ownerEntityList = ownerDao.findAll();
        List<Owner> owners = new ArrayList<>();
        for (OwnerEntity ownerEntity: ownerEntityList){
            owners.add(Mapper.mapOwnerFromEntity(ownerEntity));
        }
        return owners;
    }

    public Optional<Owner> findById(UUID uuid) {
        Optional<OwnerEntity> ownerEntity = ownerDao.findById(uuid);
        return ownerEntity.map(Mapper::mapOwnerFromEntity);
    }

    public Owner save(Owner owner){
        return Mapper.mapOwnerFromEntity(ownerDao.save(EntityMapper.mapFromOwner(owner)));
    }

    public Optional<BonsaiOwner> findBonsaiById(UUID bonsai_id) {
        return bonsaiDao.findById(bonsai_id).map(Mapper::mapfromEntity);
    }

    @Transactional
    public Optional<BonsaiOwner> updateOwner(Owner newOwner, UUID bonsaiId) {
        bonsaiDao.updateOwner(bonsaiId, EntityMapper.mapFromOwner(newOwner));
        return findBonsaiById(bonsaiId);
    }
}
