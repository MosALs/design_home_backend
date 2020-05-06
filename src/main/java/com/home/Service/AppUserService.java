package com.home.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.DTO.SearchResultDTO;
import com.home.DTO.UserRegisterationDto;
import com.home.Entity.AppUser;

@Service
public interface AppUserService {

	int deleteUser(int id);

	ResponseEntity<?> save(UserRegisterationDto appUser);

	List<SearchResultDTO> search(String areaName, String accountType, String specializationName);

	List<AppUser> searchAll(String areaName, String accountType, String specializationName, String governoratName);

	ResponseEntity<?> login(String userData, String password);

	List<AppUser> findBySearchCriteria(SearchCriteriaDto caseCriteria);


	

}
