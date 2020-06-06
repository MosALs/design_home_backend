package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.DTO.SearchResultDTO;
import com.home.Entity.AppUser;
import com.home.Service.AppUserService;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private AppUserService usersService;	
	@GetMapping(value = "/result/SearchAll")
	public DetailedSearchDTO SearchCriteria(@RequestParam(value = "account_type" , required = false) String accountType,
			@RequestParam(value =  "specialization_name" , required = false) String specializationName,
			@RequestParam(value =  "area_name" , required = false) String areaName,
			@RequestParam(value =  "governorate_name" , required = false) String governorateName){
		
		SearchCriteriaDto dto= new SearchCriteriaDto();
		dto.setAccount_Type(accountType);
		dto.setSpecializationName(specializationName);
		dto.setAreaName(areaName);
		dto.setGovernorateName(governorateName);
	  return usersService.findBySearchCriteria(dto);

}

}
