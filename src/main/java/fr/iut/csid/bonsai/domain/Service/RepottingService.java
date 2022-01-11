package fr.iut.csid.bonsai.domain.Service;


import fr.iut.csid.bonsai.domain.model.Repotting;
import fr.iut.csid.bonsai.infrastructure.RepottingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RepottingService {

    private RepottingRepository repository;

    public RepottingService(RepottingRepository repository) {
        this.repository = repository;
    }

    public Repotting save(Repotting repotting){
        return repository.save(repotting);
    }

    public List<Repotting> findAll(UUID id_bonsai){
        return repository.findAll(id_bonsai);
    }
}
