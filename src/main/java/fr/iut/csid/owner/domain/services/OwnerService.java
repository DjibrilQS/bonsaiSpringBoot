package fr.iut.csid.owner.domain.services;


import fr.iut.csid.Authentication.domain.model.AppUser;
import fr.iut.csid.owner.domain.models.BonsaiOwner;
import fr.iut.csid.owner.domain.models.Owner;
import fr.iut.csid.owner.infrastructure.OwnerRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> findAllWithMoreThan(int nbBonsai){
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream().filter(owner -> owner.getBonsais().size()>=nbBonsai).collect(Collectors.toList());
    }

    public Optional<Owner> findById(UUID uuid) {
        return ownerRepository.findById(uuid);
    }

    public Owner create(Owner owner){
        return ownerRepository.save(owner);
    }

    public Optional<BonsaiOwner> transfertBonsai(UUID owner_id, UUID bonsai_id, UUID new_owner_id){
        Optional<BonsaiOwner> bonsaiOwner = ownerRepository.findBonsaiById(bonsai_id);
        Optional<Owner> newOwner = ownerRepository.findById(new_owner_id);
        AppUser user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (bonsaiOwner.isPresent() && newOwner.isPresent() && (bonsaiOwner.get().getId_owner().equals(owner_id) || user.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN")))){
            return ownerRepository.updateOwner(newOwner.get(), bonsai_id);
        }
        else {
            return Optional.empty();
        }
    }

    public  List<BonsaiOwner> addBonsais(UUID owner_id, List<UUID> bonsai_ids){
        AppUser user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<BonsaiOwner> addedBonsais = new ArrayList<>();
        Optional<Owner> newOwner = ownerRepository.findById(owner_id);
        if (newOwner.isPresent()){
            for (UUID id : bonsai_ids){
                Optional<BonsaiOwner> bonsaiOwner = ownerRepository.findBonsaiById(id);
                if (bonsaiOwner.isPresent() && (bonsaiOwner.get().getId_owner()== null || user.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN")))){
                    ownerRepository.updateOwner(newOwner.get(), id).ifPresent(addedBonsais::add);
                }
            }
        }
        return addedBonsais;
    }

}
