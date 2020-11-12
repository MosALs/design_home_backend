package com.home.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.DTO.SearchDtoNew;
import com.home.entities.ShopEntity;



@Repository
public interface ShopRepository extends JpaRepository<ShopEntity,Integer>,JpaSpecificationExecutor {

	@Query(value ="	select sh.user_id,auser.user_name, sh.shop_name,l.location_name,a.area_name\r\n" + 
			"			from shop sh\r\n" + 
			"		    inner join location l on sh.location_id=l.id\r\n" + 
			"			inner join areas a on l.area_id=a.id\r\n" + 
			"			inner join app_user auser on sh.user_id=auser.id\r\n" + 
			"			 where a.area_name= :area_name;",nativeQuery = true)
        	List<SearchDtoNew> search(@Param("area_name") String areaName);
	

	
	void findByShopName(String shopName);



	ShopEntity findAllById(int id);
	
	ShopEntity findById(int id);
	

}
