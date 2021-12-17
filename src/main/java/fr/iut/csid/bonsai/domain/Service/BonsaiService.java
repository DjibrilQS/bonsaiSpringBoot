package fr.iut.csid.bonsai.domain.Service;

import fr.iut.csid.bonsai.domain.model.Bonsai;
import fr.iut.csid.bonsai.domain.model.Watering;
import fr.iut.csid.bonsai.exposition.BonsaiDTO;
import fr.iut.csid.bonsai.exposition.WateringDTO;
import fr.iut.csid.bonsai.exposition.WateringMapper;
import fr.iut.csid.bonsai.infrastructure.BonsaiEntity;
import fr.iut.csid.bonsai.infrastructure.BonsaiRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static fr.iut.csid.bonsai.exposition.BonsaiMapper.*;

@Service
public class BonsaiService {
    private BonsaiRepository bonsaiRepo;

    public BonsaiService(BonsaiRepository repo){
        this.bonsaiRepo = repo;
    }

    public BonsaiDTO findByID(UUID id){
        return bonsaiToDTO(this.bonsaiRepo.getBonsaiByID(id));
    }

    public BonsaiDTO save(BonsaiDTO bons) {
        if(!bons.getStatus().toLowerCase().equals("dead") && !bons.getStatus().toLowerCase().equals("alive") && !bons.getStatus().toLowerCase().equals("unknown")){
            bons.setStatus("unknown");
        }
        Bonsai bonsai = dtoToBonsai(bons);
        BonsaiEntity be = this.bonsaiRepo.createBonsai(bonsai);
        BonsaiDTO bdt = entityToDto(be);
        return bdt;
    }

    public List<BonsaiDTO> findAll() {
        return this.bonsaiRepo.getAllBonsai();
    }

    public void deleteById(UUID uuid) {
        this.bonsaiRepo.deleteBonsai(uuid);
    }

    public Watering save(Watering watering){
        return bonsaiRepo.save(watering);
    }

    public WateringDTO getWatering(UUID id_bonsai){
        List<Watering> wlist= bonsaiRepo.findAllWaterings(id_bonsai);
        if(!wlist.isEmpty()) {
            WateringDTO wdt = WateringMapper.mapFromWatering(wlist.get(0));
            return wdt;
        }
        return null;

    }

    public BonsaiDTO put(UUID uuid, String status) {
        Bonsai bonsai = this.bonsaiRepo.getBonsaiByID(uuid);

        if(status.equals("alive") || status.equals("unknown") || status.equals("dead")) {
            bonsai.setStatus(status);
        }
            BonsaiEntity be = this.bonsaiRepo.createBonsai(bonsai);
            return entityToDto(be);
    }

    public BonsaiDTO patchBonsai(BonsaiDTO bons, UUID uuid) {
        Bonsai bonsai = this.bonsaiRepo.getBonsaiByID(uuid);
        bonsai.setName(bons.getName());
        bonsai.setSpecies(bons.getSpecies());
        bonsai.setAcquisition_age(bons.getAcquisition_age());
        bonsai.setAcquisition_date(bons.getAcquisition_date());
        this.bonsaiRepo.createBonsai(bonsai);
        return mappingPatch(bonsai);
    }
}
