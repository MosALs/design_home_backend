package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.DTO.SearchResultDTO;
import com.home.Service.UsersService;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private UsersService usersService;

	@GetMapping(value = "/result")
	public List<SearchResultDTO>  search(@RequestParam ("area_name") String areaName,@RequestParam("account_type")
String accountType,@RequestParam("specialization_name")String specializationName){
		
		return usersService.search(areaName,accountType,specializationName) ;
	}

}
