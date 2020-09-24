package com.home.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.home.DTO.SearchGetAll;
import com.home.entities.AccountTypeEntity;

public interface InterfaceProjectionMethod  extends JpaRepository<AccountTypeEntity, Integer> {
	
	@Query(value = "select ac.accountTypeName as accountTypeName ,ar.areaName as areaName\r\n"
			+ "from AccountTypeEntity ac\r\n"
			+ "inner join  ShopEntity sh  on sh.accountTypeId=ac.id\r\n"
			+ "inner join LocationEntity l on sh.locationId=l.id\r\n"
			+ "inner join AreasEntity ar on l.areasByAreaId.id=ar.id\r\n")
	     List<SearchGetAll> allFourDto1();
	

}
