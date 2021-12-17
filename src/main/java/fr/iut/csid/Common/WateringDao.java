package fr.iut.csid.Common;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WateringDao extends JpaRepository<WateringEntity, UUID> {
    @Query("select w from watering w WHERE w.bonsai.id=:bonsaiId order by w.date DESC")
    List<WateringEntity> findAllByBonsaiId(@Param("bonsaiId") UUID bonsaiId);
}
