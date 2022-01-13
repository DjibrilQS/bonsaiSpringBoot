package fr.iut.csid.owner.exposition;


import fr.iut.csid.owner.domain.models.Mapper;
import fr.iut.csid.owner.domain.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> findAllWithMoreThan(@RequestParam int nbBonsai){
        return ResponseEntity.ok(ownerService.findAllWithMoreThan(nbBonsai)
                .stream()
                .map(OwnerMapper::mapDTOFromOwner)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable("uuid") UUID uuid){
        return ownerService.findById(uuid)
                .map(OwnerMapper::mapDTOFromOwner)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{uuid}/bonsais")
    public ResponseEntity<List<BonsaiOwnerDTO>> findBonsaisByOwner(@PathVariable("uuid") UUID uuid){
        return ownerService.findById(uuid)
                .map(OwnerMapper::mapDTOFromOwner)
                .map(OwnerDTO::getBonsais)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO owner){
        OwnerDTO ownerDTO = OwnerMapper.mapDTOFromOwner(ownerService.create(Mapper.mapOwnerFromDTO(owner)));
        return ResponseEntity.created(URI.create("/owners/"+ ownerDTO.getId())).body(ownerDTO);
    }

    @PostMapping("/{owner_id}/bonsai")
    public List<BonsaiOwnerDTO> addBonsai(@PathVariable("owner_id") UUID owner_id, @RequestBody List<UUID> bonsai_ids){
        return ownerService.addBonsais(owner_id, bonsai_ids).stream()
                .map(OwnerMapper::mapDTOFromBonsaiOwner)
                .collect(Collectors.toList());
    }

    @PostMapping("/{owner_id}/bonsais/{bonsai_id}/transfer")
    public ResponseEntity<BonsaiOwnerDTO> transfertBonsai(@PathVariable("owner_id") UUID owner_id, @PathVariable("bonsai_id") UUID bonsai_id, @RequestBody OwnerDTO ownerDTO){
        return ownerService.transfertBonsai(owner_id, bonsai_id, ownerDTO.getId())
                .map(OwnerMapper::mapDTOFromBonsaiOwner)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
