package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.DTO.LocationAreaDTO;
import com.home.Service.LocationService;
import com.home.entities.LocationEntity;;

@RestController
@RequestMapping(value="location")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@GetMapping
	public List<LocationEntity> getall(){
		return locationService.getAllLocation();
	}

	@GetMapping(value = "/name")
	public List<LocationEntity> getNameLocation(){
		return locationService.getName();
	}

	@GetMapping(value = "/name/area")
	public List<LocationAreaDTO> getNamearea(){
		return locationService.getAllLocationNameByAreaName();
	}
	
}
