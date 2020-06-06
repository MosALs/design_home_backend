package com.home.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.DTO.Governorates_AreasDTO;
import com.home.Entity.Areas;

@Repository
public interface AreasRepository extends JpaRepository<Areas, Integer> {

	@Query(value = "select  a.governorate_Id as governorateId , a.id as id ,  g.governorat_name "
			+ "as governoratName  ,a.area_name as areaName "
			+ " from areas a inner join governorates g on a.governorate_id=g.id", nativeQuery = true)
	List<Governorates_AreasDTO> findInfo();

	List<Areas> findByGovernorateId(int governorateId);

	@Modifying()
	@Transactional
	@Query(value = "UPDATE Areas a SET a.areaName=:newAreaName WHERE a.areaName=:oldAreaName")
	int updateArea(@Param("newAreaName") String newAreaName, @Param("oldAreaName") String oldAreaName);

	
}