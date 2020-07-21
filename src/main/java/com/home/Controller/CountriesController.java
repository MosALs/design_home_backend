package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.Entity.Areas;
import com.home.Entity.Countries;
import com.home.Service.CountriesService;
import com.home.entities.CountriesEntity;

@RestController
@RequestMapping(value = "/Country")
public class CountriesController {
	@Autowired
	CountriesService countriesService;

	// GET
	@RequestMapping(value = "/getAllCountry", method = RequestMethod.GET) // localhost:8080/Areas
	List<CountriesEntity> getAllCountries() {
		return countriesService.getAllCountries();
	}

	// Save
	@RequestMapping(value = "/ddCountry", method = RequestMethod.POST)
	public String add(@RequestBody CountriesEntity countries) {
		if (countriesService.save(countries)) {
			return "Done";
		} else {
			return "Fail";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public int updateCountry(@RequestParam(name = "newcountryName") String newcountryName,
			@RequestParam(name = "oldcountryName") String oldcountryName) {
		return countriesService.Modify(newcountryName, oldcountryName);

	}

	@RequestMapping(value ="/delete/{id}",method = RequestMethod.DELETE)
	public String deleteAreaId(@PathVariable int id) {
		countriesService.delete(id);
		return "done";

}
}