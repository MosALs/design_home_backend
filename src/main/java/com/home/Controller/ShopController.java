package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.Repository.ShopRepository;
import com.home.Service.ShopService;
import com.home.entities.ShopEntity;

@RestController
@RequestMapping(value = "rest/sh")
public class ShopController {

	@Autowired
	ShopService shopService;
	@Autowired
	ShopRepository shopRepository;

	@GetMapping
	List<ShopEntity> getAll() {
		return shopService.getAllShop();
	}

	// @PostMapping(value = "/{id}")
	@GetMapping(value = "{id}")
	ShopEntity getShopById(@PathVariable(value = "id") int id) {
		
		return shopRepository.findAllById(id);
	}

}
