package fr.iut.csid.Common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepottingDao extends JpaRepository<BonsaiEntity, UUID> {

    List<RepottingEntity> findAllBy(UUID id_bonsai);
}
