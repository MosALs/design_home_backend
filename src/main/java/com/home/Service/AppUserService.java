package com.home.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.DTO.SearchResultDTO;
import com.home.DTO.UserRegisterationDto;
import com.home.Entity.AppUser;
import com.home.entities.AppUserEntity;
import com.home.util.ReturnedResultModel;

@Service
public interface AppUserService {

	int deleteUser(int id);

	ReturnedResultModel save(UserRegisterationDto appUser);


	List<AppUser> searchAll(String areaName, String accountType, String specializationName, String governoratName);

	ResponseEntity<?> login(String userData, String password);

	DetailedSearchDTO findBySearchCriteria(SearchCriteriaDto caseCriteria);

	//ResponseEntity<?> add(UserRegisterationDto dto);
	//int  saveone(AppUserEntity appUserEntity);

	

}
