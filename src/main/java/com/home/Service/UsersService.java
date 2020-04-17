package com.home.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.home.DTO.SearchResultDTO;
import com.home.DTO.UserRegisterationDto;
import com.home.Entity.Areas;
import com.home.Entity.Branches;
import com.home.Entity.Users;

@Service
public interface UsersService {

	
	int deleteUser (int id);
	
	int ModifyName (String newUserName,String oldUserName);
	int ModifyArea(String newAreaName,String oldAreaName);
	int ModifyCountry(String newcountryName,String oldcountryName);
	
	ResponseEntity<?> save (UserRegisterationDto users);
	
	
	
	List<SearchResultDTO> search(String areaName, String accountType, String specializationName);

	ResponseEntity<?> login(String userData, String password);
	
	
}
