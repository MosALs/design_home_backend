package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.DTO.SearchDtoNew;
import com.home.DTO.ShopSearch;
import com.home.Entity.AppUser;
import com.home.entities.ShopEntity;
@Service
public interface ShopService {

	int save(ShopEntity shopEntity);

	List<ShopEntity> getAllShop();

	int getByShopID(int id);

	int getByshopName(String shopName);

	void deleteByshopID(int id);

	int ModifyByshop(String newshopName, String oldshopNamee);
	
	 //List<ShopEntity> searchAll(String areaName);

	
	DetailedSearchDTO findBySearchCriteria(SearchCriteriaDto caseCriteria);
}
