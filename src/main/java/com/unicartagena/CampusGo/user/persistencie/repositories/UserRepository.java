package com.unicartagena.CampusGo.user.persistencie.repositories;

import com.unicartagena.CampusGo.user.persistencie.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);

    Optional<UserEntity> findUserEntityByEmail(String email);


}