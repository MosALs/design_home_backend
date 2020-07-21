package com.home.repositories;

import com.home.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("userRoleReposistory")
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Integer> {
}
