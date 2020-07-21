package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.Entity.Countries;
import com.home.entities.CountriesEntity;
@Service
public interface CountriesService {

	boolean save(CountriesEntity countriesEntity);

	public int Modify(String newcountryName,String oldcountryName);

	void delete(int id);

	List<CountriesEntity> getAllCountries();
	
	List<CountriesEntity> searchCountriesByName (String countryName);

}
