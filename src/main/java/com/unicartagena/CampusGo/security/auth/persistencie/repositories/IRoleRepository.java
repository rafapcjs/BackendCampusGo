package com.unicartagena.CampusGo.security.auth.persistencie.repositories;

import com.unicartagena.CampusGo.security.auth.persistencie.rol.RoleEntity;
import com.unicartagena.CampusGo.security.auth.persistencie.rol.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

    // Para obtener varios roles por Enum
    List<RoleEntity> findRoleEntitiesByRoleEnumIn(List<String> roleNames);
    Optional<RoleEntity> findByRoleEnum(RoleEnum roleEnum);
    boolean existsByRoleEnum(RoleEnum roleEnum);
}