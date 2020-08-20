package com.home.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.entities.SpecializationEntity;

@Repository
public interface SpecializationRepository extends JpaRepository<SpecializationEntity,Integer>{
	
	
	@Modifying()
	@Transactional
	@Query(value = "UPDATE specialization s SET s.specializationName=:newspecializationName WHERE s.specializationName=:oldspecializationName",nativeQuery = true)
	int updateSpecialization(@Param("newspecializationName") String newlocationName, @Param("oldspecializationName") String oldlocationName);

	SpecializationEntity findBySpecializationName(String specializationName);

	



}
