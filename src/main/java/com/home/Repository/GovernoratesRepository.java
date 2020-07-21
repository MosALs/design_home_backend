package com.home.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.entities.GovernoratEntity;

@Repository
public interface GovernoratesRepository extends JpaRepository<GovernoratEntity, Integer> {

	
	//@Query("SELECT * FROM Governorat WHERE CustomerName LIKE '%or%';")
	
	@Modifying()
	@Transactional
	@Query(value = "UPDATE governorat g SET g.governoratName=:newgovernoratName WHERE g.governoratName=:oldgovernoratName",nativeQuery = true)
	int updateGovernorat(@Param("newgovernoratName") String newgovernoratName, @Param("oldgovernoratName") String oldgovernoratName);

	void findBygovernoratName(String governoratName);
	
}
