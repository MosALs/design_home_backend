package com.home.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.Repository.UserSearchViewRepository;
import com.home.Service.UserSearchViewService;
import com.home.View.UserSearchView;
import com.home.entities.ShopEntity;

@RestController
@RequestMapping(value="rest/usv")
public class UserSearchViewController {

	@Autowired
	UserSearchViewService UserSearchViewService;
	@Autowired
	UserSearchViewRepository userSearchViewRepository; 
	
	// @PostMapping(value = "/{id}")
	@GetMapping(value = "{id}")
	UserSearchView getShopById(@PathVariable(value = "id") int id) {
		
		return userSearchViewRepository.findAllById(id);
}
}