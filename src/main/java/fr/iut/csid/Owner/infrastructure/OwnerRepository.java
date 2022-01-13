package fr.iut.csid.Owner.infrastructure;

import fr.iut.csid.Common.OwnerDao;
import org.springframework.stereotype.Component;

@Component
public class OwnerRepository {
    private OwnerDao ownerDao;

    public OwnerRepository(OwnerDao dao){
        this.ownerDao = dao;
    }


}
