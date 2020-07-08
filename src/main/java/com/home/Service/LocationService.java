package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.DTO.Location_AreaDTO;
import com.home.entities.LocationEntity;


@Service
public interface LocationService {
	
	int save(LocationEntity locationEntity);

	 List<LocationEntity> getAllLocation();

	//استخدمها على شان الابلكيش يعرض العنوان الخاص لوحده بكل منطقه
	List<Location_AreaDTO> getAllLocationNameByAreaName();
	
	int getByLocationID(int id);
	
	int getByLocationName(String locationName);

	void deleteByLocationID(int id);

	int ModifyByLocationName(String newlocationName, String oldlocationName);

}
