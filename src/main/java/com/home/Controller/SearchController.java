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

	@GetMapping(value = "/result")
	public List<SearchResultDTO> search(@RequestParam("area_name") String areaName,
			@RequestParam("account_type") String accountType,
			@RequestParam("specialization_name") String specializationName) {

		return usersService.search(areaName, accountType, specializationName);
	}

	@GetMapping(value = "/result/all")
	public List<AppUser> searchALL(@RequestParam("area_name") String areaName, @RequestParam("account_type") String accountType,
			@RequestParam("specialization_name") String specializationName, @RequestParam("governorat_name")String governoratName) {
			
		DetailedSearchDTO dtoall=new DetailedSearchDTO();
		dtoall.getAppUser().setAccountType(accountType);
		dtoall.getAppUser().getSpecializationId().setSpecializationName(specializationName);
		dtoall.getAddress().getAreaId().setAreaName(areaName);
		dtoall.getAppUser().getAddressList();
		dtoall.getAddress().getAreaId().getGovernorateId().setGovernoratName(governoratName);
		
		//return usersService.searchAll(dtoall);
		return usersService.searchAll(areaName, accountType, specializationName, governoratName);
	}

	
	@GetMapping(value = "/result/SearchAll")
	public DetailedSearchDTO SearchCriteria(@RequestParam(value = "account_type" , required = false) String accountType, 
			@RequestParam(value = "user_name" ,  required = false) String  userName,
			@RequestParam(value =  "user_mobile" , required = false) String userMobile ,
			@RequestParam(value =  "specialization_name" , required = false) String specializationName,
			@RequestParam(value =  "area_name" , required = false) String areaName,
			@RequestParam(value =  "governorate_name" , required = false) String governorateName){
		
		SearchCriteriaDto dto= new SearchCriteriaDto();
		dto.setAccount_Type(accountType);
		dto.setUser_name(userName);
		dto.setUser_Mobile(userMobile);
		dto.setSpecializationName(specializationName);
		dto.setAreaName(areaName);
		dto.setGovernorateName(governorateName);
	  return usersService.findBySearchCriteria(dto);

}

}
