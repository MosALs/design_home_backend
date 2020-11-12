package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.DTO.LocationAreaDTO;
import com.home.DTO.SearchDtoNew;
import com.home.DTO.SearchGetAll;
import com.home.DTO.ShopSearch;
import com.home.entities.LocationEntity;


@Service
public interface LocationService {
	
	int save(LocationEntity locationEntity);

	 List<LocationEntity> getAllLocation();

	//استخدمها على شان الابلكيش يعرض العنوان الخاص لوحده بكل منطقه
	List<LocationAreaDTO> getAllLocationNameByAreaName();
	
	int getByLocationID(int id);
	
	int getByLocationName(String locationName);

	void deleteByLocationID(int id);

	int ModifyByLocationName(String newlocationName, String oldlocationName);
	
	List <SearchDtoNew> searchAll(String areaName);

	List <ShopSearch> searchAllnew(String areaName ,String  specializationName,String accountTypeName);

	List <SearchGetAll> searchAllALL();
	
	List <SearchGetAll> searchAllALLtest();
	
	List<LocationEntity> getName();
	
	
	

}
