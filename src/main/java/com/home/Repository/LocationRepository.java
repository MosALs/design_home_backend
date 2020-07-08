package com.home.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.DTO.Location_AreaDTO;
import com.home.entities.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

	@Query(value = " select l.location_name,a.area_name\r\n" + "\r\n"
			+ " from location l inner join areas a on l.area_id=a.id", nativeQuery = true)
	List<Location_AreaDTO> findInfoLocationAndArea();
	/////////////
	

	@Modifying()
	@Transactional
	@Query(value = "UPDATE location l SET l.locationName=:newlocationName WHERE l.locationName=:oldlocationName",nativeQuery = true)
	int updateLocation(@Param("newlocationName") String newlocationName, @Param("oldlocationName") String oldlocationName);


	void findByLocationName(String locationName);
}
