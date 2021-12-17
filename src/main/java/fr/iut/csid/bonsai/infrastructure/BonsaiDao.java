package fr.iut.csid.bonsai.infrastructure;


import fr.iut.csid.bonsai.exposition.BonsaiDTO;
import fr.iut.csid.bonsai.infrastructure.BonsaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {
}
