package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Entity.Countries;
import com.home.Repository.CountriesRepository;
@Service
public class CountriesServiceImp implements CountriesService{

	@Autowired
	private CountriesRepository countriesRepository;

	@Override
	public boolean save(Countries countries) {
		
		return countriesRepository.save(countries)!= null;
	}

	@Override
	public int Modify(String newcountryName,String oldcountryName) {
		
		return countriesRepository.updatecountry(newcountryName, oldcountryName);
	}

	@Override
	public void delete(int id) {
		 countriesRepository.deleteById(id);
		
	}

	@Override
	public List<Countries> getAllCountries() {
		return countriesRepository.findAll();
	
	}

	@Override
	public List<Countries> searchCountriesByName(String countryName) {
		
		return countriesRepository.findCountriesBYcountryName(countryName);
	}





}
