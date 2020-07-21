package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Entity.Countries;
import com.home.Repository.CountriesRepository;
import com.home.entities.CountriesEntity;
@Service
public class CountriesServiceImp implements CountriesService{

	@Autowired
	private CountriesRepository countriesRepository;

	@Override
	public boolean save(CountriesEntity countriesEntity) {
		
		return countriesRepository.save(countriesEntity)!= null;
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
	public List<CountriesEntity> getAllCountries() {
		return countriesRepository.findAll();
	
	}

	@Override
	public List<CountriesEntity> searchCountriesByName(String countryName) {
		
		return countriesRepository.findCountriesBYcountryName(countryName);
	}





}
