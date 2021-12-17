package fr.iut.csid.bonsai.exposition;

import fr.iut.csid.bonsai.domain.Service.BonsaiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import static fr.iut.csid.bonsai.exposition.BonsaiMapper.bonsaiToDTO;

@RestController
@RequestMapping("/bonsai")
public class BonsaiController {
    Logger log;
    private BonsaiService bonsaiService;

    public BonsaiController(BonsaiService bService) {
        this.bonsaiService = bService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid) {
        BonsaiDTO bdt;
        try {
            bdt = this.bonsaiService.findByID(uuid);
            return ResponseEntity.ok(bdt);
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{uuid}/status")
    public ResponseEntity changeStatus(@PathVariable("uuid") UUID uuid, String status) {
        try {
            this.bonsaiService.put(uuid, status);
            return ResponseEntity.status(204).build();
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{uuid}/watering")
    public ResponseEntity<WateringDTO> getWatering(@PathVariable("uuid") UUID uuid) {
        List<WateringDTO> wtdto;
        try {
            return ResponseEntity.ok(this.bonsaiService.getWatering(uuid));
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<BonsaiDTO> save(@RequestBody BonsaiDTO bons) {
        BonsaiDTO bdt;
        try {
            bdt = this.bonsaiService.save(bons);
        } catch (NullPointerException e) {
            /*modification*/
            e.printStackTrace();
            return null;
        }
        return ResponseEntity.created(URI.create("/bonsai/" + bdt.getId())).build();

    }

    //
//
    @GetMapping
    public List<BonsaiDTO> getAllBonsai() {
        return this.bonsaiService.findAll();
    }


    @DeleteMapping("/{uuid}")
    public ResponseEntity deleteBonsai(@PathVariable("uuid") UUID uuid) {
        try {
            this.bonsaiService.deleteById(uuid);
            return ResponseEntity.status(204).build();
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> modifyBonsai(@RequestBody BonsaiDTO bons, @PathVariable("uuid") UUID uuid) {
//        BonsaiDTO bdt = this.save(bons).getBody();
//        this.bonsaiService.deleteById(uuid);
        try {
            return ResponseEntity.ok(bonsaiService.patchBonsai(bons, uuid));
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}