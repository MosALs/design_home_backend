package com.home.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entities.PhoneEntity;



@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer> {

	 
}
