package com.home.repositories;

import com.home.entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("appUserEntityReposistory")
public interface AppUserRepository extends JpaRepository<AppUserEntity,Integer> , JpaSpecificationExecutor {

    Optional<AppUserEntity> findByUserName(String userName);


}
