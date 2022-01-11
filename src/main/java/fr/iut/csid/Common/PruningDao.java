package fr.iut.csid.Common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface PruningDao extends JpaRepository<PruningEntity, UUID> {
    @Query("select p from pruning p WHERE p.bonsai.id=:bonsaiId order by p.date DESC")
    List<PruningEntity> findAllByBonsaiId(@Param("bonsaiId") UUID bonsaiId);
}
