package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.DTO.Location_AreaDTO;
import com.home.Repository.LocationRepository;
import com.home.entities.LocationEntity;

@Service
public class LocationServiceImp implements LocationService{

	@Autowired
	LocationRepository locationRepository; 
	
	@Override
	public int save(LocationEntity locationEntity) {
		locationRepository.save(locationEntity);
		return 0;
	}

	@Override
	public List<LocationEntity> getAllLocation() {
		locationRepository.findAll();
		return null;
	}

	//get location and areas 
	@Override
	public List<Location_AreaDTO> getAllLocationNameByAreaName() {
		
		return null;
	}

	@Override
	public int getByLocationID(int id) {
		locationRepository.findById(id);
		return 0;
	}

	@Override
	public int getByLocationName(String locationName) {
		locationRepository.findByLocationName(locationName);
		return 0;
	}

	@Override
	public void deleteByLocationID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ModifyByLocationName(String newlocationName, String oldlocationName) {
		 locationRepository.updateLocation(newlocationName, oldlocationName);
		return 0;
	}

}
