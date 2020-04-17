package com.home.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.Entity.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Integer>{

}
