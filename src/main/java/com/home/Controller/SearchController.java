package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.DTO.SearchDtoNew;
import com.home.DTO.SearchGetAll;
import com.home.DTO.ShopSearch;
import com.home.Entity.AppUser;
import com.home.Service.AppUserService;
import com.home.Service.LocationService;
import com.home.Service.ShopService;
import com.home.Service.UserSearchViewService;
import com.home.View.UserSearchView;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private AppUserService usersService;
	@Autowired
	ShopService shopService;
	@Autowired
	LocationService locationService; 
	@Autowired
	UserSearchViewService userSearchViewService;


	@Autowired
	private com.home.services.AppUserService usersEntityService;

	/*
	 * @GetMapping(value = "/result") public List<SearchResultDTO>
	 * search(@RequestParam("area_name") String areaName,
	 * 
	 * @RequestParam("account_type") String accountType,
	 * 
	 * @RequestParam("specialization_name") String specializationName) {
	 * 
	 * return usersService.search(areaName, accountType, specializationName); }
	 */

	@GetMapping(value = "/result/all")
	public List<AppUser> searchALL(@RequestParam("area_name") String areaName, @RequestParam("account_type") String accountType,
			@RequestParam("specialization_name") String specializationName, @RequestParam("governorat_name")String governoratName) {
			
		DetailedSearchDTO dtoall=new DetailedSearchDTO();
		//dtoall.getAppUser().setAccountType(accountType);
		dtoall.getAppUser().getSpecializationId().setSpecializationName(specializationName);
		dtoall.getAddress().getAreaId().setAreaName(areaName);
		dtoall.getAppUser().getAddressList();
		dtoall.getAddress().getAreaId().getGovernorateId().setGovernoratName(governoratName);
		
		//return usersService.searchAll(dtoall);
		return usersService.searchAll(areaName, accountType, specializationName, governoratName);
	}

	
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
	  return usersEntityService.findBySearchCriteria(dto);

}
	@GetMapping(value = "/result/onrarea")
	public List<SearchDtoNew> searchALLarea(@RequestParam("area_name") String areaName) {
			
		//SearchDtoNew adn=new SearchDtoNew();
		
		//adn.getShopEntity().getLocationByLocationId().getAreasByAreaId().getAreaName();
		
		return locationService.searchAll(areaName);
	}

	
	@GetMapping(value = "/result/oneASA")
	public List<ShopSearch> search(@RequestParam("area_name") String areaName, @RequestParam("account_type_name") String accountTypeName,
			@RequestParam("specialization_name") String specializationName){
			
	//	SearchDtoNew adn=new SearchDtoNew();
		
		//adn.getShopEntity().getLocationByLocationId().getAreasByAreaId().getAreaName();
		
		return locationService.searchAllnew(areaName, specializationName, accountTypeName);
	}
	
	
	/*
	 * @GetMapping(value = "/result/all/all") public List<SearchGetAll>
	 * searchAll(@RequestParam("area_name") String areaName,
	 * 
	 * @RequestParam("account_type_name") String accountTypeName,
	 * 
	 * @RequestParam("specialization_name") String specializationName,
	 * 
	 * @RequestParam("governorat_name") String governoratName){
	 * 
	 * return locationService.searchAllALL(areaName, specializationName,
	 * accountTypeName, governoratName); }
	 */

	@GetMapping(value = "/result/all/all")
	public List<SearchGetAll> searchAll(){
		
		return locationService.searchAllALLtest();
	}
	
	@GetMapping(value = "/view/all")
	public List<UserSearchView> searchAllView(){
		
		return userSearchViewService.getAllView();
	}
	

}
