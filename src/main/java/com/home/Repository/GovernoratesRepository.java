package com.home.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.Entity.Governorates;

@Repository
public interface GovernoratesRepository extends JpaRepository<Governorates,Integer> {

}
