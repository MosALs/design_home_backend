package com.home.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.Service.GovernoratesService;
import com.home.entities.GovernoratEntity;

@RestController
@RequestMapping(value = "governorat")
public class GovernoratesController {

	@Autowired
	GovernoratesService governoratesService;

	@GetMapping
	public List<GovernoratEntity> getAll() {
		return governoratesService.getAllGovernorates();
	}
}
