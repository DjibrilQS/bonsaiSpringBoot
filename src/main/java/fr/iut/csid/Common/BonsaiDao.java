package fr.iut.csid.Common;


import fr.iut.csid.Common.BonsaiEntity;
import fr.iut.csid.Common.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {
    @Modifying
    @Query("update bonsai b set b.owner = :owner where b.id = :bonsaiId")
    void updateOwner(@Param("bonsaiId") UUID bonsaiId, @Param("owner") OwnerEntity owner);
}
