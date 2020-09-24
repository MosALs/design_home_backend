package com.home.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.entities.AreasEntity;

@Repository
public interface AreasRepository extends JpaRepository<AreasEntity, Integer> {
	
	//List<AreasEntity> findByGovernoratId(int governoratId);

	AreasEntity findByAreaName(String areaName);

	
	@Modifying()
	@Transactional
	@Query(value = "UPDATE Areas a SET a.areaName=:newAreaName WHERE a.areaName=:oldAreaName")
	int updateArea(@Param("newAreaName") String newAreaName, @Param("oldAreaName") String oldAreaName);

}