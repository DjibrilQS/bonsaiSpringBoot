package fr.iut.csid.Common;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserDao extends JpaRepository<UserEntity, UUID> {
    UserEntity findByUsername(String username);
    @Query(value = "select * from users u where u.id_user=:id", nativeQuery = true)
    List<String>findAuthorityByUserId(@Param("id")UUID id);

}
