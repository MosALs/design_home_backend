package com.home.Controller;

import java.util.Collection;
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
import com.home.Entity.Specialization;
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
	public List<AppUser> SearchCriteria(@RequestParam("account_type") String accountType, @RequestParam("user_name") String  userName,
			@RequestParam("user_mobile") String userMobile){
		//,@RequestParam("specialization_name") String AppUser) {
		SearchCriteriaDto dto= new SearchCriteriaDto();
		AppUser appUser =new AppUser();
		dto.setAccount_Type(accountType);
		dto.setUser_name(userName);
		dto.setUser_Mobile(userMobile);
	  return usersService.findBySearchCriteria(dto);

}

}
