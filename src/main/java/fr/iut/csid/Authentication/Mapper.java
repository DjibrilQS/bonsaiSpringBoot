package fr.iut.csid.Authentication;


import fr.iut.csid.Authentication.domain.model.UserModel;
import fr.iut.csid.Authentication.exposition.UserDTO;
import fr.iut.csid.Common.UserEntity;

public class Mapper {


    public static UserModel mapFromEntity(UserEntity userEntity){
        String auth = null;
        if (!userEntity.getAuthorities().isEmpty()){
            auth = userEntity.getAuthorities().get(0).getAuthority();
        }
        return new UserModel(userEntity.getId_user(), userEntity.getUsername(), userEntity.getPassword(), auth);

    }

    public static UserDTO mapFromModel(UserModel userModel) {
        return new UserDTO(userModel.getId(), userModel.getUsername(), userModel.getAuthority());
    }
}
